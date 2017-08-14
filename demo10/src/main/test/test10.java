import org.junit.Test;
import redis.clients.jedis.Jedis;
import serve.RedisMessageListener;

/**
 * Created by LZP on 2017/8/9.
 */
public class test10 {
    @Test
    public void testReceive(){
        Jedis jedis =new Jedis("localhost");
        RedisMessageListener redisMessageListener =new RedisMessageListener();
        jedis.subscribe(redisMessageListener,"lzpChat");
    }
    @Test
    public void testReceive1(){
        Jedis jedis =new Jedis("localhost");
        RedisMessageListener redisMessageListener =new RedisMessageListener();
        jedis.subscribe(redisMessageListener,"lzpChat");
    }
}
