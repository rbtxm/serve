package com.rbtxm.redis.service;

import com.rbtxm.redis.config.RedisTemplate;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月06日  19时19分28秒
 **/
public class RedisService {
    private RedisTemplate redisTemplate;

    public RedisService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }



    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param timeout 时间
     * @param timeUnit 时间颗粒度
     */
    public <T> void setCacheObject(final String key, final T value, final Long timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout)
    {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @param unit 时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 获取有效时间
     *
     * @param key Redis键
     * @return 有效时间
     */
    public long getExpire(final String key)
    {
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断 key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public Boolean hasKey(String key)
    {
        return redisTemplate.hasKey(key);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(final String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 删除单个对象
     *
     * @param key
     */
    public boolean deleteObject(final String key)
    {
        return redisTemplate.delete(key);
    }

    /**
     * 删除集合对象
     *
     * @param collection 多个对象
     * @return
     */
    public long deleteObject(final Collection collection)
    {
        return redisTemplate.delete(collection);
    }

    /**
     * 缓存List数据
     *
     * @param key 缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public <T> long setCacheList(final String key, final List<T> dataList) {
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> List<T> getCacheList(final String key)
    {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 缓存Set
     *
     * @param key 缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    public <T> BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet) {
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext())
        {
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * 获得缓存的set
     *
     * @param key
     * @return
     */
    public <T> Set<T> getCacheSet(final String key)
    {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap) {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * 获得缓存的Map
     *
     * @param key
     * @return
     */
    public <T> Map<String, T> getCacheMap(final String key)
    {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 往Hash中存入数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @param value 值
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 往zset中存入数据
     * @param <T>
     * @param key
     * @param value
     * @param score  zset的分数
     */
    public <T> void addZsetValue(final String key,final T value,final long score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 往zset中存入数据
     * @param <T>
     * @param key
     * @param value
     * @param score  zset的分数
     */
    public <T> void addZsetValue(final String key,final Set<ZSetOperations.TypedTuple<T>> sets) {
        redisTemplate.opsForZSet().add(key, sets);
    }

    /**
     * 弹出分数最高的Zset值，并删除
     * @param <T>
     * @param key
     * @return
     */
    public <T> ZSetOperations.TypedTuple<T> popZsetMaxValue(final String key)
    {
        return redisTemplate.opsForZSet().popMax(key);
    }
    /**
     * 弹出分数最低的Zset值，并删除
     * @param <T>
     * @param key
     * @return
     */
    public <T> ZSetOperations.TypedTuple<T> popZsetMinValue(final String key)
    {
        return redisTemplate.opsForZSet().popMin(key);
    }

    /**
     * 弹出分数最低的Zset值，并删除
     * @param <T>
     * @param key
     * @return
     */
    public <T> Set<ZSetOperations.TypedTuple<T>> popZsetMinValue(final String key, Long length)
    {
        return redisTemplate.opsForZSet().popMin(key,length);
    }

    /**
     * 获取score分数最高的值，但不会删除
     * @param <T>
     * @param key
     * @return
     */
    public <T> ZSetOperations.TypedTuple<T> getZsetMaxValue(final String key)
    {
        Set<ZSetOperations.TypedTuple<T>> zsetMaxRangeValue = getZsetMaxRangeValue(key,0);
        Optional<ZSetOperations.TypedTuple<T>> max = zsetMaxRangeValue.stream().findAny();
        if(max.isPresent()) {
            return max.get();
        }
        return null;
    }
    /**
     * 获取score分数最高的值
     * @param <T>
     * @param key
     * @param count 需要获取多少个
     * @return
     */
    public <T> Set<ZSetOperations.TypedTuple<T>> getZsetMaxRangeValue(final String key, final long count) {
        Set<ZSetOperations.TypedTuple<T>> set = redisTemplate.opsForZSet().reverseRangeWithScores(key, 0, count);
        Optional<Set<ZSetOperations.TypedTuple<T>>> optional = Optional.ofNullable(set);
        return optional.isPresent() ? set : new LinkedHashSet<>();
    }

    /**
     * 根据Score范围获取Zset
     * @param <T>
     * @param key
     * @param start
     * @param end
     * @return
     */
    public <T> Set<T> getZsetRangeValue(final String key,final long start, final long end) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, start, end);
    }

    public boolean removeZsetValue(final String key,final long start, final long end) {
        return redisTemplate.opsForZSet().removeRange(key, start, end) > 0;
    }

    /**
     * 检查zset的长度是否超出指定值
     * @param key
     * @param count
     * @return true：超过指定值；false：没有超过指定值
     */
    public boolean checkZsetLength(final String key, final long count) {
        Long size = redisTemplate.opsForZSet().size(key);
        return count > size;
    }

    /**
     * 检查zset的长度是否超出指定值
     * @param key
     * @param count
     * @return 超过指定的长度
     */
    public Long getZsetLimitLength(final String key, final long count) {
        Long size = redisTemplate.opsForZSet().size(key);
        return size - count > 0 ? size - count : 0;
    }


    /**
     * 检查hash的长度是否超出指定值
     * @param key
     * @param count
     * @return true：超过指定值；false：没有超过指定值
     */
    public boolean checkHashLength(final String key, final long count) {
        Long size = redisTemplate.opsForHash().size(key);
        return count > size;
    }


    /**
     * 获取Hash中的数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public <T> T getCacheMapValue(final String key, final String hKey) {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
    public <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hKeys) {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 删除Hash中的某条数据
     *
     * @param key Redis键
     * @param hKey  Hash键
     * @return 是否成功
     */
    public boolean deleteCacheMapValue(final String key, final String hKey) {
        // return Boolean.TRUE.equals(redisTemplate.opsForHash().delete(key, hKey));
        return redisTemplate.opsForHash().delete(key, hKey) > 0;
    }
    /**
     * 删除Hash中的某条数据
     *
     * @param key Redis键
     * @param hKey  Hash键
     * @return 是否成功
     */
    public boolean deleteCacheMapValue(final String key, final Object[] hKey) {
        // return Boolean.TRUE.equals(redisTemplate.opsForHash().delete(key, hKey));
        return redisTemplate.opsForHash().delete(key, hKey) > 0;
    }

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    public <T> Collection<T> keys(final String pattern)
    {
        return redisTemplate.keys(pattern);
    }

    /**
     * 切换redis连接的数据库
     * @param dbNum redis数据库的编号
     * @return {@link RedisService}
     */
    public RedisService setDB(int dbNum) {
        RedisTemplate.REDIS_DB_INDEX.set(dbNum);
        return this;
    }
    public RedisTemplate getCurrentRedisTemplate() {
        return this.redisTemplate;
    }
}
