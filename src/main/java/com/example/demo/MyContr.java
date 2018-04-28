package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MyContr {

    @Autowired
    UserMBean user;


    @GetMapping
    public String getProfilePartsOnClassId(Model model) {

        if (user.getUserName() != "Ksn1") {
            user.setUserName("KSN");
        }

        model.addAttribute("userName", user.getUserName());

        return "hello";
    }

}



