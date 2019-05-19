package com.bluesquanium.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
@RequestMapping()
public class WelcomeController {

    @GetMapping(value = {"/", "/welcome"})
    public String showLoginPage(ModelMap model) {
        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        model.put("name", currentUserName);
        return "welcome";
    }

}