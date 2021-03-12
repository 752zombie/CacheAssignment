package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<Integer, String> map;

    public Cache() {
        map = new HashMap<>();
    }

    public String get(int key) {
        return map.get(key);
    }

    public void set(int key, String value) {
        map.put(key, value);
    }

    public boolean has(int key) {
        return map.containsKey(key);
    }

    public void delete(int key) {
        map.remove(key);
    }


}
