package com.francoismaki.calc.core.operations.binary;

import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.ast.Expression;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractionTest {
    @Test
    void testSumaDeDosConstantes(){
        Expression five = new Constant(5);
        Expression ten = new Constant(10);
        Expression add = new Subtraction(five, ten);

        double answer = add.evaluate();

        assertEquals(-5.0, answer, 0.0001);

    }
}
