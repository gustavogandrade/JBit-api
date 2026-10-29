package com.example.jbit_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kline")
public class KlineController {

    @GetMapping
    public String getKline() {
        return "Kline data" + " Controller is working!";
    }
}
