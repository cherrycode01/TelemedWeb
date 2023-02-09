package com.telemedweb.telemedweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @Controller
    public class loginController {
    }

    @GetMapping("/login")
    public String loginLogin (Model model) {
        return "login.html";
    }

    @GetMapping("/doctorLogin")
    public String doctorLogin (Model model) {
        return "doctordashboard.html";
    }

    @GetMapping("/patientLogin")
    public String patientLogin (Model model) {
        return "patientrecord.html";
    }
}

/* kako napraviti login za doktora i pacijenta na istom loginu*/
