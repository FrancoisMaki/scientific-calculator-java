package com.francoismaki.calc.core.parser;

import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.operations.binary.*;
import com.francoismaki.calc.core.operations.unary.*;

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
                    operatorStack.push(token);
                    break;

                case PAREN_RIGHT:
                    while (!operatorStack.isEmpty() && operatorStack.peek().getType() != TokenType.PAREN_LEFT){
                        outputQueue.add(operatorStack.pop());
                    }
                    if (!operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.PAREN_LEFT){
                        operatorStack.pop();
                    }
                    if (!operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.FUNCTION){
                        outputQueue.add(operatorStack.pop());
                    }
            }
        }

        while (!operatorStack.isEmpty()){
            Token top = operatorStack.pop();
            if (top.getType() == TokenType.PAREN_LEFT || top.getType() == TokenType.PAREN_RIGHT){
                throw new IllegalArgumentException("Error de sintaxis, parentesis incompletos");
            }
            outputQueue.add(top);
        }

        return outputQueue;
    }

    public Expression buildAST(List<Token> rpnTokens){
        Deque<Expression> stack = new ArrayDeque<>();

        for (Token token : rpnTokens){
            switch (token.getType()){
                case NUMBER:
                    stack.push(new Constant(Double.parseDouble(token.getValue())));
                    break;

                case OPERATOR:
                    Expression right = stack.pop();
                    Expression left = stack.pop();

                    stack.push(createBinaryOperation(token.getValue(), left, right));
                    break;

                case FUNCTION:
                    Expression operand = stack.pop();
                    stack.push(createUnaryOperation(token.getValue(), operand));
                    break;
            }
        }
        return stack.pop();
    }

    private Expression createBinaryOperation(String op, Expression left, Expression right){
        return switch (op){
            case "+"    ->  new Addition(left, right);
            case "-"    ->  new Substraction(left, right);
            case "*"    ->  new Multiplication(left, right);
            case "/"    ->  new Division(left, right);
            case "^"    ->  new Power(left, right);
            default     ->  throw new IllegalArgumentException("Operador desconocido: " + op);
        };
    }

    private Expression createUnaryOperation(String func, Expression operand){
        return switch (func){
            case "sin"          ->  new Sin(operand);
            case "cos"          ->  new Cos(operand);
            case "tan"          ->  new Tan(operand);
            case "ln"           ->  new Ln(operand);
            case "log10"        ->  new Log10(operand);
            case "squareRoot"   ->  new SquareRoot(operand);
            default -> throw new IllegalArgumentException("Funcion desconocida " + func);
        };
    }
}


