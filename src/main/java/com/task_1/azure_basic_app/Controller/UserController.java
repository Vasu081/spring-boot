package com.task_1.azure_basic_app.Controller;


import com.task_1.azure_basic_app.Models.Users;
import com.task_1.azure_basic_app.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
private UserService userService;
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String addUser(@RequestBody Users users)
    {
        System.out.println(users.getFirst_name());
        System.out.println("done dana done");
        return userService.createuser(users);
    }
    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable long id)
    {

        return userService.getUserById(id);
    }

    @GetMapping("/readAll")
    public List<Users> getALlUserBYID()
    {

        return userService.allUsers();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateUser(@PathVariable Long id,@RequestBody Users users)
    {
        System.out.println(users);
        return userService.updateUser(id,users);

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        return userService.deleteById(id);
    }
}
