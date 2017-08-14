package serve;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by LZP on 2017/8/9.
 */
public class RedisMessageListener extends JedisPubSub {
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        super.onPSubscribe(pattern, subscribedChannels);
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
    }

    @Override
    public void onMessage(String channel, String message) {
        super.onMessage(channel, message);
        System.out.println("channel:" + channel + "receives message :" + message);
        //this.unsubscribe();
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        super.onUnsubscribe(channel, subscribedChannels);
        System.out.println("channel:" + channel + "is been unsubscribed:" + subscribedChannels);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        super.onSubscribe(channel, subscribedChannels);
    }

    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
    }

    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
    }

    public RedisMessageListener() {
        super();
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        super.onPMessage(pattern, channel, message);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        super.onPUnsubscribe(pattern, subscribedChannels);
    }

    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
    }

    @Override
    public void onPong(String pattern) {
        super.onPong(pattern);
    }

    @Override
    public void unsubscribe() {
        super.unsubscribe();
    }

    @Override
    public void punsubscribe() {
        super.punsubscribe();
    }

    @Override
    public void ping() {
        super.ping();
    }

    @Override
    public boolean isSubscribed() {
        return super.isSubscribed();
    }

    @Override
    public void proceedWithPatterns(Client client, String... patterns) {
        super.proceedWithPatterns(client, patterns);
    }

    @Override
    public void proceed(Client client, String... channels) {
        super.proceed(client, channels);
    }

    @Override
    public int getSubscribedChannels() {
        return super.getSubscribedChannels();
    }
}
