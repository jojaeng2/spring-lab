package com.example.demo;


import com.example.demo.controller.SomethingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SomethingControllerTest {

    @Autowired
    private SomethingController somethingController;

    @Test
    public void test() {
        somethingController.print();
    }
}
