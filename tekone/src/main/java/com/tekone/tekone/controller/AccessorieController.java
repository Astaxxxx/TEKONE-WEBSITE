package com.tekone.tekone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class AccessorieController {
   @RequestMapping(value = "/accessoriePage")
   public String accessoriePage() {
      return "accessoriePage";
   }
}