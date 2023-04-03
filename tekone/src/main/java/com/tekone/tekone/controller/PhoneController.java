package com.tekone.tekone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class PhoneController {
   @RequestMapping(value = "/phonePage")
   public String phonesPage() {
      return "phonesPage";
   }
}