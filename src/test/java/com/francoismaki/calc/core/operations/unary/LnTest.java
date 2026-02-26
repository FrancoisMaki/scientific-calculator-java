package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.operations.unary.Ln;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {
    @Test
    void testLnNumPositivo(){
        Expression ln = new Ln(new Constant(Math.E));
        assertEquals(1.0, ln.evaluate(), 0.0001);
    }

    @Test
    void testLnNumeroNegativo(){
        Expression lnNegativo = new Ln(new Constant(-1));
        assertThrows(ArithmeticException.class, () ->{
            lnNegativo.evaluate();
        });
    }
}
