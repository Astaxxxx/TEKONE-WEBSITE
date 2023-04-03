package com.tekone.tekone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class ConsolesController {
   @RequestMapping(value = "/consolesPage")
   public String consolesPage() {
      return "consolesPage";
   }
}