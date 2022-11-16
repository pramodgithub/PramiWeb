package com.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLCheckController {

    @GetMapping("/check")
    @ResponseBody
    public String checkAPI(@RequestParam String testName) {

        return "Hi, Welcome " + testName;

    }

}
