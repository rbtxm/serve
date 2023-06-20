package com.fanttec.common.core.utils.thread;

import java.util.Map;

/**
 * 线程变量工具类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
@SuppressWarnings("unchecked")
public class ThreadLocalUtil {
	private ThreadLocalUtil() {}
	private static final ThreadLocal<Map<String, Object>> threadLocal = ThreadUtil.createThreadLocal(Maps::newHashMap);

    public static Map<String, Object> getThreadLocal(){
        return threadLocal.get();
    }
    
   
	public static <T> T get(String key) {
        Map<String,Object> map = threadLocal.get();
        return (T)map.get(key);
    }

    public static <T> T get(String key,T defaultValue) {
    	Map<String,Object> map = threadLocal.get();
        return map.get(key) == null ? defaultValue : (T)map.get(key);
    }

    public static void set(String key, Object value) {
    	Map<String,Object> map = threadLocal.get();
        map.put(key, value);
    }

    public static void set(Map<String, Object> keyValueMap) {
    	Map<String,Object> map = threadLocal.get();
        map.putAll(keyValueMap);
    }

    public static void remove() {
        threadLocal.remove();
    }

}
