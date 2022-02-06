package com.infinitelambda.tapcicd;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreeterController {

    @GetMapping("/{name}")
    ResponseEntity<String> greet(@PathVariable String name) {
        return ResponseEntity.ok("Hi, " + Utils.normalize(name) + "!");
    }
}
