package org.example.main;

import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        String beansNames[] = context.getBeanDefinitionNames();

        System.out.println(Arrays.toString(beansNames));
    }
}
