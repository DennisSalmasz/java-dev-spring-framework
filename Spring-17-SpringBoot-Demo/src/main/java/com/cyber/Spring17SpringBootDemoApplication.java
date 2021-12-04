package com.cyber;

import com.cyber.interfaces.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring17SpringBootDemoApplication {

    public static void main(String[] args) {
        //creates container and all beans !!
        ApplicationContext container = SpringApplication.run(Spring17SpringBootDemoApplication.class, args);

        Course course = container.getBean("java",Course.class);
        System.out.println(course.getTeachingHours());;
    }

}
