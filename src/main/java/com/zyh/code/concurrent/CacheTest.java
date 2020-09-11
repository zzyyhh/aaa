package com.zyh.code.concurrent;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yinghui.zhang on 2020/8/26
 */
public class CacheTest {
    public static void main(String[] args) {

        LruCache<String, String> cache = new LruCache<>(1);
        //test1
        cache.putKV("1", "aa");
        System.out.println(cache.getValue("1"));

        cache.putKV("2", "bb");
        System.out.println(cache.getValue("1"));
        System.out.println(cache.getValue("2"));

        //
        ////test2
        //for (int i = 0;i < 10; i++) {
        //    cache.putKV(String.valueOf(i), );
        //}
    }


    public static class LruCache<K,V> {

        private LinkedHashMap<K, V> cache;

        private int size;

        public LruCache(int size) {
            this.size = size;
            this.cache = new LinkedHashMap<K,V>(size, 0.75f, true) {
                private static final long serialVersionUID = 8411542782009718268L;
                @Override
                protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                    return cache.size() > size;
                }
            };
        }


        public V getValue(K k) {
            return cache.get(k);
        }

        public void putKV(K k, V v) {
            cache.put(k, v);
        }
    }
}
