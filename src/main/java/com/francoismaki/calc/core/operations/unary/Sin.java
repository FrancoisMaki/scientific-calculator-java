package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;

public class Sin extends UnaryOperation{
    public Sin(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        return Math.sin(operand.evaluate());
    }
}
