package com.francoismaki.calc.core.binary;

import com.francoismaki.calc.core.Constant;
import com.francoismaki.calc.core.Expression;
import com.francoismaki.calc.core.operations.binary.Substraction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubstractionTest {
    @Test
    void testSumaDeDosConstantes(){
        Expression five = new Constant(5);
        Expression ten = new Constant(10);
        Expression add = new Substraction(five, ten);

        double answer = add.evaluate();

        assertEquals(-5.0, answer, 0.0001);

    }
}
