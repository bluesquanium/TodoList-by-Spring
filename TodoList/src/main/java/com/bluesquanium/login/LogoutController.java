package com.bluesquanium.login;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("name")
@RequestMapping()
public class LogoutController {

    @GetMapping(value = {"/logout"})
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // auth 정보 가져옴.
        if(auth != null) { // auth가 null이 아니란 말은 어떤 사용자가 등록되어 있다는 말.
            new SecurityContextLogoutHandler().logout(request, response, auth); // logout
            request.getSession().invalidate(); // session 종료
        }


        return "redirect:/";
    }
}