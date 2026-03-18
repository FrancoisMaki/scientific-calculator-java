package com.francoismaki.calc.core.parser;

import java.util.Map;

public class Parser {
    private static final Map<String, Integer> PRECEDENCE = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2,
            "^", 3
    );

    private int getPrecedence(String operator){
        return PRECEDENCE.getOrDefault(operator, 0);
    }

    private boolean isRightAssociative(String operator){
        return operator.equals("^");
    }
}


