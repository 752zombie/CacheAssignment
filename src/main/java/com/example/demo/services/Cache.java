package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Cache {
    private Map<Object, Object> map;

    public Cache() {
        map = new HashMap<>();
    }

    public Object get(Object key) {
        return map.get(key);
    }

    public void set(Object key, Object value) {
        map.put(key, value);
    }

    public boolean has(Object key) {
        return map.containsKey(key);
    }

    public void delete(Object key) {
        map.remove(key);
    }

    public void setTTL(Object key, int seconds) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                delete(key);
            }
        }, seconds * 1000L);

    }


}
