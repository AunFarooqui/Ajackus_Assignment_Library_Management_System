package com.library.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(LibraryManagementApplication.class, args);
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Performing clean shutdown...");
            ctx.close();
        }));
	}

}
