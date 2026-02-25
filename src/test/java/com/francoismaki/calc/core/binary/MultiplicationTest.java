package com.francoismaki.calc.core.binary;

import com.francoismaki.calc.core.Constant;
import com.francoismaki.calc.core.Expression;
import com.francoismaki.calc.core.operations.binary.Multiplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationTest {
    @Test
    void testMultiplicacionDeDosConstantes(){
        Expression five = new Constant(5);
        Expression ten = new Constant(10);
        Expression multiplication = new Multiplication(five, ten);

        double answer = multiplication.evaluate();

        assertEquals(50.0, answer, 0.0001);

    }
}
