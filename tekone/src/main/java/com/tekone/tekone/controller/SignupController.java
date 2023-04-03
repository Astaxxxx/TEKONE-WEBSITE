package com.tekone.tekone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class SignupController {
   @RequestMapping(value = "/signup")
   public String signup() {
      return "signupNew";
   }
}