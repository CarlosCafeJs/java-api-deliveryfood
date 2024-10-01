package br.com.senai.delivery.foodsenai.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/home")
public class Home {

    @GetMapping
    public String homeControlelr() {
        return "Ola Terra!";
    }
    

}
