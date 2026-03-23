package com.francoismaki.calc.core.parser;

import java.util.*;

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

    //  Shunting-Yard Algorithm

    public List<Token> parseToRPN(List<Token> tokens){
        List<Token> outputQueue = new ArrayList<>();
        Deque<Token> operatorStack =  new ArrayDeque<>();

        for (Token token : tokens){
            switch (token.getType()){
                case NUMBER:
                    outputQueue.add(token);
                    break;

                case FUNCTION:
                    outputQueue.add(token);
                    break;

                case OPERATOR:
                    while (!operatorStack.isEmpty() &&
                            (operatorStack.peek().getType() == TokenType.OPERATOR ||
                                    operatorStack.peek().getType() == TokenType.FUNCTION)){

                        Token top = operatorStack.peek();

                        if (top.getType() == TokenType.FUNCTION ||
                            getPrecedence(top.getValue()) > getPrecedence(token.getValue()) ||
                                (getPrecedence(top.getValue()) == getPrecedence(token.getValue()) &&
                                        !isRightAssociative(token.getValue()))){
                            outputQueue.add(operatorStack.pop());
                        }else {
                            break;
                        }
                    }

                    operatorStack.push(token);
                    break;

                case PAREN_LEFT:
            }
        }

        return outputQueue;
    }
}


