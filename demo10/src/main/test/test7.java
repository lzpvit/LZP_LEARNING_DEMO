import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LZP on 2017/8/2.
 */
public class test7 {
    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost");
        System.out.println("server is runing:"+jedis.ping());
        System.out.println(jedis.get("lzp1"));
        jedis.lpush("lzp2","help","me","please");
        System.out.println(jedis.lrange("lzp2",0,-1));
        System.out.println(jedis.keys("*"));
    }

    /**
     * mongodb 需要先在Windows上将它注册为服务/或者在bin下命令行mongod.exe  --dbpath F:\mongoData\db
     */
    @Test
    public void test2(){
        try {
            MongoClient mongoClient = new MongoClient("localhost",27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("lzp1");
            MongoCollection mongoCollection = mongoDatabase.getCollection("test9");
            Document document = new Document("title","mongo");
            document.append("key1","db").append("key2","hello");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            mongoCollection.insertMany(documents);

            FindIterable<Document> findIterable = mongoCollection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
