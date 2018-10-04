package ru.saidgadjiev.map;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by said on 01.10.2018.
 */
public class LRUCacheTest {

    @Test
    public void test_v1() {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put("test1", "1");

        Assert.assertEquals(1, lruCache.getSize());

        //Move test1 to head because it is most frequently at this time and test2 is least frequently used
        lruCache.get("test1");
        lruCache.get("test1");

        lruCache.put("test2", "2");

        lruCache.get("test2");
        lruCache.get("test2");
        lruCache.get("test2");
        lruCache.get("test2");
        //Remove test2 test3 is most frequently used
        lruCache.put("test3", "3");

        Assert.assertEquals(2, lruCache.getSize());

        Assert.assertNull(lruCache.get("test1"));

        Assert.assertEquals("3", lruCache.get("test3"));

    }

}