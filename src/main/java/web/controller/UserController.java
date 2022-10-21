package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("allUsers", userService.getAllUsers());
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
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }
    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, ModelMap modelMap) {
        User user = userService.getUser(id);
        modelMap.addAttribute("user", user);
        return "user-info";
    }
//    @GetMapping()
//    public String getCarsCount(@RequestParam(required = false) Integer count, ModelMap model) {
//        int numCars = count == null ? carsDao.getCars().size() : count;
//        model.addAttribute("listCars", carsDao.getCars(numCars));
//        return "cars";
//    }
//    @GetMapping(value = "/")
//    public String printWelcome(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("I'm Spring MVC application");
//        messages.add("5.2.0 version by sep'19 ");
//        model.addAttribute("messages", messages);
//        return "index";
//    }
}
