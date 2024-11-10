package main.java.swiftcache.evictionstrategy;

import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FIFOEvictionStrategy<K, V> implements EvictionStrategy<K, V> {

  private final Logger logger = Logger.getLogger(FIFOEvictionStrategy.class.getName());

  @Override
  public void evict(Map<K, V> cache, Queue<K> evictionQueue) {
    K evictedKey = evictionQueue.poll();

    if (evictedKey != null) {
      cache.remove(evictedKey);

      logger.log(Level.INFO, "Key {0} evicted", evictedKey);
    }
  }

  @Override
  public void updateQueue(K key, Queue<K> evictionQueue) {
    if (!evictionQueue.contains(key)) {
      evictionQueue.offer(key);

      logger.log(Level.INFO, "Key {0} added to eviction queue", key);
    }
  }
}
