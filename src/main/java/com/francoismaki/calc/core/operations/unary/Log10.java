package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;

public class Log10 extends UnaryOperation{
    public Log10(Expression operand) {
        super(operand);
    }

    @Override
    public double evaluate() {
        if (operand.evaluate() > 0)
            return Math.log10(operand.evaluate());
        else
            throw new ArithmeticException("El logaritmo de base 10 solo esta definido para numeros mayores a 0");
    }
}
