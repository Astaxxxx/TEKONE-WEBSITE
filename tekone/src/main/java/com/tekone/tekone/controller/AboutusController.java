package com.tekone.tekone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class AboutusController {
   @RequestMapping(value = "/aboutus")
   public String aboutus() {
      return "aboutus";
   }
}