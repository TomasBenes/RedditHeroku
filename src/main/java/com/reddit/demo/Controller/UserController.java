package com.reddit.demo.Controller;

import com.reddit.demo.Model.User;
import com.reddit.demo.Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserServiceImpl userService;


    public UserController (UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterPage(@ModelAttribute User user){
        /*User user = new User(username, password);*/
        this.userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        /*model.addAttribute("users", this.userService.findAllUsers());*/
        return "login";
    }

    @PostMapping("/login")
    public String postLoginPage(@RequestParam String username, @RequestParam String password){
        this.userService.findByUsernamePassword(username, password);
        return "redirect:/" + "?username=" + username;
    }
}
