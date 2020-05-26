package ru.learning.conditionalspringboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        var k = "enabled".equalsIgnoreCase(context.getEnvironment().getProperty("MYENV"));
        return k;
    }
}
