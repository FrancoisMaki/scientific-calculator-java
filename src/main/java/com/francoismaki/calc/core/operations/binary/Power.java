package com.francoismaki.calc.core.operations.binary;

import com.francoismaki.calc.core.Expression;

public class Power implements Expression {
    private final Expression left;
    private final Expression right;

    public Power(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return Math.pow(left.evaluate(), right.evaluate());
    }
}
