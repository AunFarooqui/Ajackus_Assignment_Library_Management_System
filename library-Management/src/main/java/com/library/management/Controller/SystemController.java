package com.library.management.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.LibraryManagementApplication;

@RestController
public class SystemController {
    
	 
    private final ConfigurableApplicationContext context;

    public SystemController(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @PostMapping("/exit")
    public ResponseEntity<String> exitSystem() {
        new Thread(() -> {
            try {
                Thread.sleep(500);
                context.close();  // Proper context closure
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        return ResponseEntity.ok("Application shutting down...");
    }
}