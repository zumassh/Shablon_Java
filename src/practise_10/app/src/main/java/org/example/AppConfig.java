package org.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "StreetFighter")
    public Fighter StreetFighter(){
        return new StreetFighter();
    }
    @Bean(name = "Boxer")
    public Fighter Boxer(){
        return new Boxer();
    }
    @Bean(name = "Judoka")
    public Fighter Judoka(){
        return new Judoka();
    }
}