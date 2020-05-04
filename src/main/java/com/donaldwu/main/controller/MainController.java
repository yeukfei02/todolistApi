package com.donaldwu.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    @RequestMapping(value="/", method = RequestMethod.GET)
    public static Map<String, String> getMain() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("message", "todolistApi");
        return testMap;
    }
}
