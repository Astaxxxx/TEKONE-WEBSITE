package com.tekone.tekone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class ContactsController {
   @RequestMapping(value = "/contacts")
   public String contacts() {
      return "contacts";
   }
}