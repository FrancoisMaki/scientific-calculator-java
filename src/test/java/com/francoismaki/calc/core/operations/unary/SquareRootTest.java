package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.ast.Expression;
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
