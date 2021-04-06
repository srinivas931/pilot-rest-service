package com.example.restservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {

    private  static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        long id = counter.incrementAndGet();
        System.out.println(id); // Add logger - log4j
        return ResponseEntity.ok(new Greeting(id, String.format(template, name)));
    }

    @PostMapping("/{greetingId}")
    public ResponseEntity<Greeting> add(@PathVariable long greetingId) {
        return ResponseEntity.ok(new Greeting(greetingId, "New Greeting Created"));
    }
}
