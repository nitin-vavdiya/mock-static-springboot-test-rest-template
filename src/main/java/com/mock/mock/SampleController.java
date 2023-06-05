package com.mock.mock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {


    @GetMapping(path = "/test")
    public String test(){
        return StaticClass.getMessage();
    }
}
