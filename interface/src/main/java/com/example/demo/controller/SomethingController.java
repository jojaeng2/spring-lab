package com.example.demo.controller;

import com.example.demo.service.SomethingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SomethingController {

    private final SomethingService somethingService;

    public void print() {
        System.out.println("somethingService = " + somethingService);
    }
}
