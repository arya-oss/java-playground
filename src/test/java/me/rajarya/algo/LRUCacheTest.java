package me.rajarya.algo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheTest {

    @Test
    public void testLRUCacheSize() {
        LRUCache cache = new LRUCache();
        cache.refer(1);
        cache.refer(2);
        cache.refer(1);
        cache.refer(3);
        assertEquals(cache.size(), 3);
    }
}
