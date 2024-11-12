package swiftcache.readpolicy;

import java.util.Map;

public interface IReadingPolicy<K, V> {
    V read(Map<K, V> cacheMap, K key, CacheRepository<K, V> repository);
}