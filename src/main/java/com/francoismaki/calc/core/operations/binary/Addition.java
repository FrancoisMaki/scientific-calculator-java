package com.francoismaki.calc.core.operations.binary;

import com.francoismaki.calc.core.ast.Expression;

public class Addition implements Expression {
    private final Expression left;
    private final Expression right;

    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
