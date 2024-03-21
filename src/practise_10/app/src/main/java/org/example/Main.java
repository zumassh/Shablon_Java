package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
    public static void main(String[] args) {

        String beanName1 = "StreetFighter";
        String beanName2 = "Boxer";
        String beanName3 = "Judoka";
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Fighter fighter = (Fighter) context.getBean(beanName1);

        if (fighter != null) {
            fighter.doFight();
        } else {
            System.out.println("Bean with name " + beanName1 + " not found");
        }

        fighter = (Fighter) context.getBean(beanName2);

        if (fighter != null) {
            fighter.doFight();
        } else {
            System.out.println("Bean with name " + beanName2 + " not found");
        }

        fighter = (Fighter) context.getBean(beanName3);

        if (fighter != null) {
            fighter.doFight();
        } else {
            System.out.println("Bean with name " + beanName3 + " not found");
        }
    }
}