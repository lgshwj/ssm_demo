package org.demo.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.demo.entity.User;
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

    private final JedisPool jedisPool;

    private RuntimeSchema<User> schema = RuntimeSchema.createFrom(User.class);

    public RedisDao(String host , int port) {
        jedisPool = new JedisPool(host,port);
    }

    public User getUser(Integer userId) {

        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = KEY_PERFIX + userId;

                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    User user = schema.newMessage();

                    ProtostuffIOUtil.mergeFrom(bytes, user, schema);
                    return user;
                }
            } finally {
                jedis.close();
            }

        } catch (Exception e) {
            logger.error(e.getMessage() , e);
        }

        return null;
    }

    public String putUser(User user) {

        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = KEY_PERFIX + user.getId();
                byte[] bytes = ProtobufIOUtil.toByteArray(user, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes() , timeout , bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage() , e);
        }
        return null;

    }
}
