package com.hzs.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Google Guava Cache
 *
 * @author hezhensheng3
 * @date 2019-12-31 18:01
 **/
public class GuavaCacheTest {
    /**
     * cache的实例
     */
    final static Cache<Integer, String> CACHE = CacheBuilder.newBuilder()
            // 设置cache初始值大小
            .initialCapacity(10)
            // 设置并发数
            .concurrencyLevel(5)
            // 设置数据存活时间
            .expireAfterWrite(10, TimeUnit.SECONDS)
            // 构建cache实例
            .build();

    /**
     * 测试cache的使用
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(CACHE.getIfPresent(1));

    }
}
