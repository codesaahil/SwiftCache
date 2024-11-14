package swiftcache.readpolicy;

import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadThroughPolicy<K, V> implements ReadPolicy<K, V> {

    private static final Logger logger = Logger.getLogger(ReadThroughPolicy.class.getName());
    
    @Override
    public V read(Map<K, V> cache, K key, Function<K, V> func) {
        V value = cache.get(key);

        if (value == null) {
            value = func.apply(key);

            if (value != null) {
                cache.put(key, value);

                logger.log(Level.INFO, "Read miss for key: {0}, fetched from data source", key);
            }

            return value;
        }

        logger.log(Level.INFO,"Read hit for key: {0}", key);

        return value;
    }
}
