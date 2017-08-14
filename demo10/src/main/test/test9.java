import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Scanner;

/**
 * Created by LZP on 2017/8/9.
 */
public class test9 {
    @Test
    public void testPublish() throws Exception{
        Jedis jedis = new Jedis("localhost");
        jedis.publish("lzpChat","hello everyone");

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String say =scanner.nextLine();
            jedis.publish("lzpChat",say);
            Thread.sleep(1000);
        }
    }

}
