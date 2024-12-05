package com.laaumari;

import com.laaumari.SERVICES.IMetier;
import com.laaumari.SERVICES.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SecurityContext.authenticateUser("laaumari", "laaumari", new String[]{"ADMIN","USER"});
        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.getClass().getName());
        metier.process();
        System.out.println(metier.compute());    }
}