package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;

public class Tan extends UnaryOperation{
    public Tan(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        return Math.tan(operand.evaluate());
    }
}
