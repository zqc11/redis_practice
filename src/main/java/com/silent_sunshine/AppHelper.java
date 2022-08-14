package com.silent_sunshine;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 * @author zhouqichun
 */
public final class AppHelper {

    private static final int PORT = 6379;
    private static final int INITIAL_CAPACITY = 16;

    private AppHelper() {
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", PORT);
        jedis.disconnect();
    }

    public static void addArticle(Jedis conn, String id, String title) {
        Map hash = new HashMap<String, Object>(INITIAL_CAPACITY);
        hash.put("title", title);
        conn.hset("article:" + id, hash);
    }
}
