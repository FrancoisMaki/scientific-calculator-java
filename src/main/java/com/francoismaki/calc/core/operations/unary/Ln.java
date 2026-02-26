package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;

public class Ln extends UnaryOperation{
    public Ln(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        if (operand.evaluate() > 0)
            return Math.log(operand.evaluate());
        else
            throw new ArithmeticException("El logaritmo natural solo esta definido para numeros mayores a 0");
    }
}
