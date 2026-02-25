package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.Expression;

public class SquareRoot implements Expression{
    private final Expression value;

    public SquareRoot(Expression value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        double eval = value.evaluate();
        if (eval < 0){
            throw new ArithmeticException("Raiz cuadrada de negativo, conlleva numeros imaginarios");
        }
        return Math.sqrt(eval);
    }
}
