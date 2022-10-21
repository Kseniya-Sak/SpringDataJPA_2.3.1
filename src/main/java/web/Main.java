package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImp;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImp();
        User user = userService.getUser(2);
        System.out.println(user);
        user.setAge(40);
        userService.updateUser(user);
        User user1 = userService.getUser(2);
        System.out.println(user1);


    }
}
