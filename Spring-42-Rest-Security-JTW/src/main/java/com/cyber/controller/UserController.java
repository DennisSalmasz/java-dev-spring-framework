package com.cyber.controller;

import com.cyber.entity.ResponseWrapper;
import com.cyber.entity.User;
import com.cyber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAll(){
        List<User> users = userService.getAll();
        return ResponseEntity.ok(new ResponseWrapper("Done",users));
    }
}
