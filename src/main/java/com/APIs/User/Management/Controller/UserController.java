package com.APIs.User.Management.Controller;

import com.APIs.User.Management.Entity.User;
import com.APIs.User.Management.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        User SavedUser = userService.CreateUser(user);
        return ResponseEntity.ok(SavedUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> GetUser(@PathVariable("id") Long userId){
        User user = userService.GetUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id")Long userId,
                                           @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.UpdateUser(user);
        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteId(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully Deleted!", HttpStatus.OK);
    }


}
