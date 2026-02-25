package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;

public abstract class UnaryOperation implements Expression {
    protected final Expression operand;

    protected UnaryOperation(Expression operand) {
        this.operand = operand;
    }
}
