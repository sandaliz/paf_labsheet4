package com.example.greetingapi;

import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GreetingController {
    
    private static final String template = "Hello, %s!";

    private final AtomicLong count = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(count.incrementAndGet(), String.format(template, "World"));
    }
    
    @GetMapping("/greeting/name")
    public Greeting getMethodName(@RequestParam(value = "name", defaultValue = "Sandali") String name) {
        return new Greeting(count.incrementAndGet(), String.format(template, name));
    }
    

}
