package com.flightreservation.app.controller;


import com.flightreservation.app.model.User;
import com.flightreservation.app.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String sayIndex() {
        return "index";
    }

    @RequestMapping("/register")
    public String sayRegister() {
        return "registration";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, ModelMap modelMap) {
        try {
            User user1 = userRepository.save(user);
            modelMap.addAttribute("msg", "UserAdded Successfully");
            return "login/login";
        } catch (Exception exception) {
            modelMap.addAttribute("msg", "sorry! register is un successful");
        }
        return "registration";
    }

    @RequestMapping("/loginPage")
    public String sayLogin(){
        return "login/login";
    }


//    check user
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute("email") String email, @ModelAttribute("password") String password, ModelMap modelMap) {
        try {
            User user = userRepository.findUserByEmail(email);
            if (user.getPassword().equals(password)) {
                modelMap.addAttribute("msg", "login successfully");
                return "/userHome/home";
            }
        } catch (Exception ignored) {

        }
        modelMap.addAttribute("msg", "sorry! please check username or password");
        return "login/login";
    }


}
