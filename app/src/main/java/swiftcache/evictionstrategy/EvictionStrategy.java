package swiftcache.evictionstrategy;

import java.util.Map;
import java.util.Queue;


public interface EvictionStrategy<K, V> {
	void evict(Map<K, V> cache, Queue<K> evictionQueue);

	void updateQueue(K key, Queue<K> evictionQueue);
}