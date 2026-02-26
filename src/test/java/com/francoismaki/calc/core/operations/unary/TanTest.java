package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.operations.unary.Tan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TanTest {
    @Test
    void testTan(){
     Expression tanCero = new Tan(new Constant(0));
     assertEquals(0.0, tanCero.evaluate(), 0.0001);

     Expression tanPiCuarto = new Tan(new Constant(Math.PI/4));
     assertEquals(1.0, tanPiCuarto.evaluate(), 0.0001);
    }
}
