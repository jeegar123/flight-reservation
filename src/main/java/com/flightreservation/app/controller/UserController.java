package com.flightreservation.app.controller;


import com.flightreservation.app.model.User;
import com.flightreservation.app.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private final UserRepository userRepository;

   private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String sayIndex() {
        logger.info("sayIndex() :index.jsp open");
        return "index";
    }

    @RequestMapping("/register")
    public String sayRegister() {
        logger.info("sayRegistration(): registration.jsp open");
        return "registration";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, ModelMap modelMap) {
        try {
            logger.info("saveUser(User)"+"get user Deatils"+user.toString());
            User user1 = userRepository.save(user);
            logger.info("user saved");
            modelMap.addAttribute("msg", "UserAdded Successfully");
            logger.info("redirect to login page");
            return "login/login";
        } catch (Exception exception) {
            logger.error("Error occured in registartion");
            modelMap.addAttribute("msg", "sorry! register is un successful");
        }
        logger.info("redirect to registration.jsp page");
        return "registration";
    }

    @RequestMapping("/loginPage")
    public String sayLogin() {
        logger.info("sayLogin():open login.jsp page");
        return "login/login";
    }


    //    check user
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("email") String email, @ModelAttribute("password") String password, ModelMap modelMap) {
        try {
            logger.info("login(String username,String password)");
            logger.info("find username from repository"+email);
            User user = userRepository.findUserByEmail(email);
            if (user.getPassword().equals(password)) {
                logger.info("password match");
                modelMap.addAttribute("msg", "login successfully");
                logger.info("redirect to home.jsp page");
                return "/userHome/home";
            }
        } catch (Exception ignored) {

        }
        logger.error("invalid username or password");
        modelMap.addAttribute("msg", "sorry! please check username or password");
        return "login/login";
    }


}
