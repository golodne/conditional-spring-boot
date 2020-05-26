package ru.learning.conditionalspringboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@ConditionalOnProperty(value = "spacestation.enabled",havingValue = "true") //properties in application.properties
@ConditionalOnClass(name = "ru.learning.conditionalspringboot.TestModel") //if have model
@ConditionalOnResource(resources = {"classpath:test1.txt"})
@Conditional(MyConditional.class)
public class SpaceStateController {
    @GetMapping("/pingaliens")
    public Mono<String> pingAliens() {
        return Mono.just("Hi Aliens, coming a cup of coffee");
    }
}
