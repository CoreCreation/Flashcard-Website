package net.corecreationstudios.flashcard.flashcard;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlashcardConfig {

    @Bean
    CommandLineRunner commandLineRunner(FlashcardRepository repo){
        return args -> {
            Flashcard one = new Flashcard("Hi", "你好");
            Flashcard two = new Flashcard("Dog", "狗");

            repo.saveAll(List.of(one,two));
        };
    }
}
