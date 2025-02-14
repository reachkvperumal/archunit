package com.kv.archunit.demo.archunit.controller;

import com.kv.archunit.demo.archunit.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class DemoController {

    private final DemoService demoService;

}
