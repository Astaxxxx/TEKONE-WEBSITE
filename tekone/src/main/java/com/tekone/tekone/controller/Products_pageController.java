package com.tekone.tekone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class Products_pageController {
   @RequestMapping(value = "/products_page")
   public String products_page() {
      return "products_page_1";
   }
}