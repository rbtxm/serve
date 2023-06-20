package com.fanttec.common.core.utils.thread;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;


/**  
 * 线程池工具类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
@Slf4j
public class ThreadUtils {
    /**
     * 线程池map
     */
    private static final Map<String, ThreadPoolExecutor> POOL_MAP = new ConcurrentHashMap<>();
    private static final ThreadPoolExecutor DEFAULT_THREAD_POOL_EXECUTOR = createFixedPool("ThreadUtilsDefaultPool", 5);
    /**
     * 用于高并发实时任务的线程池
     * 线程池不限制线程上限,且默认持有20个核心线程,但非核心线程仅存活较短时间将销毁
     * 用于即时异步的短期任务
     */
    private static final ThreadPoolExecutor CACHE_THREAD_POOL = new ThreadPoolExecutor(
            20,
            Integer.MAX_VALUE,
            15L,
            TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            getThreadFactory("RealTimeTaskPool")
    );

    static {
        CACHE_THREAD_POOL.prestartAllCoreThreads();
    }

    /**
     * 生成线程池工厂的格式化
     *
     * @param poolName
     * @return
     */
    private static String genThreadFactoryNameFormat(String poolName) {
        if (poolName == null) {
            poolName = "ThreadPool";
        }
        poolName = poolName.trim();
        return poolName + "-%03d";
    }

    /**
     * 获取线程工厂
     *
     * @param poolName
     * @return
     */
    public static ThreadFactory getThreadFactory(String poolName) {
        return new ThreadFactoryBuilder()
                .setNameFormat(genThreadFactoryNameFormat(Optional.ofNullable(poolName).orElse("RealTimeTaskPool")))
                .setDaemon(true)
                .build();
    }

    /**
     * 创建固定线程数的线程池
     *
     * @param poolName
     * @return
     */
    public static ThreadPoolExecutor createFixedPool(String poolName, int poolSize) {
        if (poolName == null) {
            poolName = "ThreadUtilsDefaultPool";
        }
        if (poolSize <= 0 || poolSize >= 50) {
            poolSize = 5;
        }
        poolName = poolName.trim();
        return new ThreadPoolExecutor(
                poolSize,
                poolSize,
                15L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2000),
                getThreadFactory(poolName)
        );
    }

    /**
     * 将任务放入线程池中执行
     *
     * @param poolName 线程池名称
     * @param runnable 任务
     */
    public static void run(String poolName, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        Optional.ofNullable(getPool(poolName))
                .ifPresent(pool -> pool.execute(runnable));
    }

    /**
     * 将任务放入线程池中,等待一段时间后执行
     *
     * @param poolName   线程池名称
     * @param runnable   任务
     * @param delayValue 延迟数值,默认为0
     * @param timeUnit   时间单位,默认为毫秒
     */
    public static void runDelay(String poolName, Runnable runnable, Long delayValue, TimeUnit timeUnit) {
        run(poolName, () -> {
            try {
                Optional.ofNullable(timeUnit)
                        .orElse(TimeUnit.MILLISECONDS)
                        .sleep(Optional.ofNullable(delayValue).orElse(0L));
            } catch (InterruptedException e) {
                log.error("执行异常", e);
                return;
            }
            runnable.run();
        });
    }

    /**
     * 将任务放入线程池中执行,并返回一个可用来查看状态的对象
     *
     * @param poolName 线程池名称
     * @param callable 任务
     * @param <T>
     * @return
     */
    public static <T> FutureTask<T> task(String poolName, Callable<T> callable) {
        if (callable == null) {
            return new FutureTask<T>(() -> null);
        }
        ThreadPoolExecutor threadPoolExecutor = getPool(poolName);
        FutureTask task = new FutureTask(callable);
        threadPoolExecutor.execute(task);
        return task;
    }

    /**
     * 启动一个线程执行任务
     *
     * @param runnable 任务
     * @return
     */
    public static Future runNow(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("任务不能为空");
        }
        return CACHE_THREAD_POOL.submit(runnable);
    }

    /**
     * 启动一个线程执行任务,并返回一个FutureTask对象
     *
     * @param callable
     * @param <T>
     * @return
     */
    public static <T> FutureTask<T> runTask(Callable<T> callable) {
        if (callable == null) {
            return new FutureTask<T>(() -> null);
        }
        FutureTask task = new FutureTask(callable);
        CACHE_THREAD_POOL.submit(task);
        return task;
    }


    /**
     * 获取线程池
     *
     * @param poolName
     * @return
     */
    private static ThreadPoolExecutor getPool(String poolName) {
        return getPool(poolName, 5);
    }

    /**
     * 获取线程池
     *
     * @param poolName     该参数将会自动大写去空
     * @param corePoolSize 核心线程数,该参数仅在首次创建时生效
     * @return
     */
    private static ThreadPoolExecutor getPool(String poolName, int corePoolSize) {
        ThreadPoolExecutor threadPoolExecutor = null;
        if (poolName == null) {
            return DEFAULT_THREAD_POOL_EXECUTOR;
        }
        poolName = poolName.trim().toUpperCase();
        threadPoolExecutor = POOL_MAP.get(poolName);
        if (threadPoolExecutor == null) {
            synchronized (ThreadUtils.class) {
                threadPoolExecutor = POOL_MAP.get(poolName);
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = createFixedPool(poolName, corePoolSize);
                    POOL_MAP.put(poolName, threadPoolExecutor);
                }
            }
        }
        return threadPoolExecutor;
    }

    /**
     * 多次尝试,直到返回的结果不为null
     *
     * @param callable   查询方法
     * @param retryTimes 重试次数,范围[1-20],每次间隔1秒.当重复请求总时间达到20秒后,即便次数未到,也会终止轮询
     * @param <T>
     * @return
     */
    public static <T> T queryUntilNotNull(Callable<T> callable, int retryTimes) {
        if (retryTimes <= 0) {
            retryTimes = 1;
        }
        if (retryTimes >= 20) {
            retryTimes = 20;
        }
        long deadLine = System.currentTimeMillis() + 20 * 1000;
        for (int i = 0; i < retryTimes; i++) {
            T resultTemp = null;
            try {
                resultTemp = callable.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (resultTemp != null) {
                return resultTemp;
            } else {
                if (System.currentTimeMillis() >= deadLine) {
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
        return null;
    }

    /**
     * 多次尝试,直到返回的结果不为null
     *
     * @param callable 查询方法
     * @param <T>
     * @return
     */
    public static <T> T queryUntilNotNull(Callable<T> callable) {
        return queryUntilNotNull(callable, 20);
    }

    /**
     * 将线程加入到当前线程中
     *
     * @param threads
     */
    public static void join(Thread... threads) {
        if (threads != null) {
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    log.error("线程发生中断异常", e);
                    break;
                }
            }
        }
    }

    /**
     * 获取task的结果
     *
     * @param task
     * @param ifnull
     * @param <T>
     * @return
     */
    public static <T> T getTaskResult(FutureTask<T> task, T ifnull) {
        if (task == null) {
            return null;
        }
        try {
            return task.get();
        } catch (Exception e) {
            return ifnull;
        }
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {

        }
    }

//    public static void runInTime(Long time,TimeUnit timeUnit,Runnable runnable){
//        Thread thread = new Thread(runnable);
//        thread.start();
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                thread.interrupt();
//            }
//        },);
//    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(String poolName) {
        return new ScheduledThreadPoolExecutor(1, getThreadFactory(poolName));
    }

}


