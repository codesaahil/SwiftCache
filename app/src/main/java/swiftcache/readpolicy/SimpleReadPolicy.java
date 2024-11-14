package swiftcache.readpolicy;

import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleReadPolicy<K ,V> implements ReadPolicy<K, V> {
    private static final Logger logger = Logger.getLogger(SimpleReadPolicy.class.getName());

    @Override
    public V read(Map<K, V> cache, K key, Function<K, V> func) {
        V value = cache.get(key);

        if (value == null) {
            logger.log(Level.INFO, "Read miss for key: {0}", key);
            return null;
        }

        logger.log(Level.INFO, "Read hit for key: {0}", key);
        return value;
    }
}
