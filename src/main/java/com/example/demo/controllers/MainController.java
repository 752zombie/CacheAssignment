package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.Cache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    Cache cache;

    public MainController() {
        cache = new Cache();
    }

    @ResponseBody
    @GetMapping("/get-user-data")
    public String getUserData(@RequestParam int id) throws InterruptedException{
        if (!cache.has(id)) {
            User user = new User(id);
            String userString = user.getDataSlow();
            cache.set(id, userString);
            // Set time to live for a short time for easier testing
            cache.setTTL(id, 60);
        }

        return (String) cache.get(id);
    }
}
