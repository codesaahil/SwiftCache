package swiftcache.evictionstrategy;

import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LRUEvictionStrategy<K, V> implements EvictionStrategy<K, V> {

    private static final Logger logger = Logger.getLogger(LRUEvictionStrategy.class.getName());
    
    @Override
    public void evict(Map<K, V> cache, Queue<K> evictionQueue) {
        K evictedKey = evictionQueue.poll();
        cache.remove(evictedKey);

        logger.log(Level.INFO, "Key {0} evicted (LRU)", evictedKey);
    }

    @Override
    public void updateQueue(K key, Queue<K> evictionQueue) {
        evictionQueue.remove(key);
        evictionQueue.offer(key);

        logger.log(Level.INFO, "Key {0} added to eviction queue (LRU)", key);
    }
}
