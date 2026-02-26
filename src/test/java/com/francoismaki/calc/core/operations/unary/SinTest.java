package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.operations.unary.Sin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {
    @Test
    void SinTest(){
        Expression sinCero = new Sin(new Constant(0));
        assertEquals(0.0, sinCero.evaluate(), 0.0001);

        Expression sinPiMedio = new Sin(new Constant(Math.PI/2));
        assertEquals(1.0, sinPiMedio.evaluate(), 0.0001);

        Expression sinPi = new Sin(new Constant(Math.PI));
        assertEquals(0.0, sinPi.evaluate(), 0.0001);

        Expression sinTresPiMedios = new Sin(new Constant((Math.PI*3)/2));
        assertEquals(-1.0, sinTresPiMedios.evaluate(), 0.0001);
    }
}
