package com.cyber.controller;

import com.cyber.annotation.DefaultExceptionMessage;
import com.cyber.entity.AuthenticationRequest;
import com.cyber.entity.ResponseWrapper;
import com.cyber.entity.User;
import com.cyber.exception.ServiceException;
import com.cyber.service.UserService;
import com.cyber.util.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Authenticate Controller",description = "Authenticate API")
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    @DefaultExceptionMessage(defaultMessage = "Bad Credentials")
    @Operation(summary = "Login to application")
    public ResponseEntity<ResponseWrapper> doLogin(@RequestBody AuthenticationRequest authenticationRequest){

        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();

        User foundUser = userService.readByUsername(username);

        //authenticate username & password in DB
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        authenticationManager.authenticate(authenticationToken);

        //since authentication is done, create token now !!
        String jwtToken = jwtUtil.generateToken(foundUser);

        //send response & token
        return ResponseEntity.ok(new ResponseWrapper("Login Succesfull!",jwtToken));
    }

    @PostMapping("/create-user")
    @DefaultExceptionMessage(defaultMessage = "This user already exist !!")
    @Operation(summary = "Create a new user")
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody User user) throws ServiceException {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(new ResponseWrapper("User has been created successfully",createdUser));
    }
}
