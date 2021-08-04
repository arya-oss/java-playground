package me.rajarya.algo;

import java.util.*;

/**
 * Discards the least recently used items first from memory
 * pages: 1, 2, 3, 2, 3, 4, 1
 * capacity: 3
 * 1 -> 1
 * 2 -> 2, 1
 * 3 -> 3, 2, 1
 * 2 -> 2, 3, 1
 * 3 -> 3, 2, 1
 * 4 -> 4, 3, 2
 * 1 -> 1, 4, 3
 *
 */
public class LRUCache {
    private final Deque<Integer> dq;

    private final Set<Integer> set;

    private static final int CACHE_SIZE = 3;

    public LRUCache() {
        this.dq = new LinkedList<>();
        this.set = new HashSet<>();
    }

    public void refer(int page) {
        if (!set.contains(page)) {
            if (dq.size() == CACHE_SIZE) {
                set.remove(dq.removeLast());
            }
        } else {
            dq.remove(page);
        }
        dq.push(page);
        set.add(page);
    }

    public int size() {
        return this.set.size();
    }
}
