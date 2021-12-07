package com.cyber.controller;

import com.cyber.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model){

        //binding data to html
        model.addAttribute("name","Danny");
        model.addAttribute("course","Hello Spring Boot :)");

        String subject = "MVC";
        model.addAttribute("subject",subject);

        //create random studentId - [0,1000] and show in the UI
        int id = new Random().nextInt(1000);
        model.addAttribute("id",id);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(99);
        numbers.add(4444);
        numbers.add(499999);
        model.addAttribute("numbers",numbers);

        //bind your birthday
        LocalDate birthday = LocalDate.now().minusYears(38);
        model.addAttribute("birthday",birthday);

        Student student = new Student(1,"George","Smith");
        model.addAttribute("student",student);

        return "student/welcome";
    }

    @GetMapping("register")
    public String homePage2(){
        return "student/register";
    }

}
