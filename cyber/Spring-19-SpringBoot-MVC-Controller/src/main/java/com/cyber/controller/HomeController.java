package com.cyber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/home/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("name is " + name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariable2(@PathVariable String name, @PathVariable String email){
        System.out.println("name is " + name);
        System.out.println("email is " + email);
        return "home";
    }

    //http://localhost:8080/home/course?course=spring
    @GetMapping("/home/course")
    public String requestParamEx(@RequestParam String course){
        System.out.println("course is " + course);
        return "home";
    }

    @GetMapping(value = "/course")
    public String requestParamEx2(@RequestParam (value = "name", required = false, defaultValue = "cyber") String name){
        System.out.println("course is " + name);
        return "home";
    }

    @GetMapping("home/course2")
    public String requestParamEx3(@RequestParam (value = "course2", required = false, defaultValue = "cyber") String name){
        System.out.println("course is " + name);
        return "home";
    }
}
