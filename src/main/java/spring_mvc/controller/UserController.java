package spring_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_mvc.model.User;
import spring_mvc.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/users";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "/user/addUser";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }


    @GetMapping("/editUser")
    public String editUser(Model model, @RequestParam("id") int id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "/user/updateUser";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


    @GetMapping("/deleteUser")
    public String deleteUser(Model model, @RequestParam("id") int id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "/user/deleteUser";
    }

}