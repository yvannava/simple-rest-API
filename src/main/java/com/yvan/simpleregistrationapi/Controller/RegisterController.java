package com.yvan.simpleregistrationapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.yvan.simpleregistrationapi.Model.User;
import com.yvan.simpleregistrationapi.Service.UserService;


@RestController
public class RegisterController {
    
    @Autowired
    UserService userService;  
    
    @CrossOrigin(origins = "http://localhost:5173") 
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerUser(@RequestBody User user){
        userService.saveUser(user);
        System.out.println(user.toString());
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        
        return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getUsers(){
        System.out.println("Get All User Endpoint reached.");
        return new ResponseEntity<List<User>>(userService.getUsers(),HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<HttpStatus> updateUser(@PathVariable int id, @RequestBody User user){
        userService.updateUser(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/removeUser/{id}")
    public ResponseEntity<HttpStatus> removeUser(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
