package net.corecreationstudios.flashcard;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //Just toying around, this "Greeting" is not needed
    @GetMapping("/greeting")
    public GreetingTest greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingTest(counter.incrementAndGet(), String.format(template, name));
    }
}
