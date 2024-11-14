package swiftcache.readpolicy;

import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RefreshAheadPolicy<K, V> implements ReadPolicy<K, V> {
    private static final Logger logger = Logger.getLogger(RefreshAheadPolicy.class.getName());

    @Override
    public V read(Map<K, V> cache, final K key, Function<K, V> func) {
        V value = cache.get(key);

        new Thread(() -> {
            V freshValue = func.apply(key);
            cache.put(key, freshValue);

            logger.log(Level.INFO, "Value for key: {0} refreshed in background", key);
        }).start();

        return value;
    }
}
