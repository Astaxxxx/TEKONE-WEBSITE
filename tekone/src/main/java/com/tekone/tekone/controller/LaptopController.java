package com.tekone.tekone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class LaptopController {
   @RequestMapping(value = "/laptopPage")
   public String laptopPage() {
      return "laptopPage";
   }
}