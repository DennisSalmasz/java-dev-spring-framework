package com.cyber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //business logic happens here
public class HomeController {

    //3 income requests - all return the same view: home !!
    //localhost:8080/
    @RequestMapping("/")
    public String getRequestMapping(){
        return "home";
    }

    //localhost:8080/danny
    @RequestMapping(method = RequestMethod.GET, value = "/danny")
    public String getRequestMapping2(){
        return "home";
    }

    //localhost:8080/cyber
    @RequestMapping(method = RequestMethod.DELETE, value = "/cyber")
    public String getRequestMapping3(){
        return "home";
    }

    @GetMapping("/spring")
    public String getMappingEx(){
        return "home";
    }

    @PostMapping("/spring")
    public String getMappingEx2(){
        return "home";
    }
}
