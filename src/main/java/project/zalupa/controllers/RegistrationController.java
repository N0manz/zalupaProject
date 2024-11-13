package project.zalupa.controllers;

import project.zalupa.model.User;
import project.zalupa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    // Отображение страницы регистрации
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    // Обработка данных регистрации
    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        // Создаем нового пользователя и сохраняем его
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("ROLE_USER");

        userService.saveUser(user);

        model.addAttribute("message", "Регистрация прошла успешно!");
        return "register";
    }
}
