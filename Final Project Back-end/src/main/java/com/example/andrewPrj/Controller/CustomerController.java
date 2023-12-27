package com.example.andrewPrj.Controller;

import com.example.andrewPrj.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CustomerController {

    @Autowired
    private final CustomerService customerService;
}
