package com.pey.rengoku;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/default")
public class DefaultApiController {

    @GetMapping
    public Map<String, String> getHello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "hellooo");
        return response;
    }
}
