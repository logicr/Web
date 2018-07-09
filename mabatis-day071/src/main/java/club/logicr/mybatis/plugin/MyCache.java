package club.logicr.mybatis.plugin;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author Jan
 */
public class MyCache implements Cache {
    private final String id;
    private final ConcurrentHashMap<Object,Object> cache = new ConcurrentHashMap<Object, Object>();
    private final Logger logger = LoggerFactory.getLogger(MyCache.class);
    public MyCache(String id) {
        if(null ==id){
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void putObject(Object key, Object value) {
       this.cache.put(key,value);
       this.logger.debug("{}{}",key,value);
    }

    public Object getObject(Object key) {
        this.logger.debug("{}",key);
        return this.cache.get(key);
    }

    public Object removeObject(Object key) {
        this.logger.debug("{}",key);
        return this.cache.remove(key);
    }

    public void clear() {
        this.cache.clear();
    }

    public int getSize() {
        return this.cache.size();
    }

    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
