package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.operations.unary.Cos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {
    @Test
    void TestCos(){
        Expression cosCero = new Cos(new Constant(0));
        assertEquals(1.0, cosCero.evaluate(), 0.0001);

        Expression cosPi2 = new Cos(new Constant(Math.PI/2));
        assertEquals(0.0, cosPi2.evaluate(), 0.0001);

        Expression cosPi = new Cos(new Constant(Math.PI));
        assertEquals(-1.0, cosPi.evaluate(), 0.0001);
    }
}
