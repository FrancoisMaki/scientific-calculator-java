package com.francoismaki.calc.core.unary;

import com.francoismaki.calc.core.Constant;
import com.francoismaki.calc.core.Expression;
import com.francoismaki.calc.core.operations.unary.SquareRoot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareRootTest {
    @Test
    void testRaices(){
        Expression nine = new Constant(9);
        Expression squareRoot = new SquareRoot(nine);

        double answer = squareRoot.evaluate();

        assertEquals(3, answer, 0.0001);
    }
}
