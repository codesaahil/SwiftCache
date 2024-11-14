package swiftcache.readpolicy;

import java.util.Map;
import java.util.function.Function;

public interface ReadPolicy<K, V> {
    V read(Map<K, V> cacheMap, K key, Function<K, V> func);
}