package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceJPAImp;

@Controller
public class UserController {

    private final UserServiceJPAImp userService;

    public UserController(UserServiceJPAImp userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String getAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("allUsers", userService.findAll());
        return "index-start";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            userService.save(user);
        } else {
            userService.update(user);
        }
        return "redirect:/";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, ModelMap modelMap) {
        User user = userService.findById(id);
        modelMap.addAttribute("user", user);
        return "user-info";
    }
}