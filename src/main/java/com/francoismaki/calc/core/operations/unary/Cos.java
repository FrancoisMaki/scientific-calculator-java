package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;

public class Cos extends UnaryOperation{
    public Cos(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        return Math.cos(operand.evaluate());
    }
}
