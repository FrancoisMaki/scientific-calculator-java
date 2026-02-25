package com.francoismaki.calc.core.operations.binary;

import com.francoismaki.calc.core.ast.Expression;

public class Division implements Expression {
    private final Expression left;
    private final Expression right;

    public Division(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        if (right.evaluate() == 0)
            throw new ArithmeticException("Division por cero no permitida");
        else
            return left.evaluate() / right.evaluate();
    }
}
