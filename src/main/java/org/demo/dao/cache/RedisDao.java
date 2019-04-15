package org.demo.dao.cache;

import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created with IDEA
 * author:ligang
 * Date:2019/4/14
 * Time:17:22
 * Description:
 */
public class RedisDao {

    private final Logger logger = LoggerFactory.getLogger(RedisDao.class);

    private static final String KEY_PERFIX = "demo:";

    //private final JedisPool jedisPool;

    //private RuntimeSchema<>

    public RedisDao(String host , int port) {

    }
}
