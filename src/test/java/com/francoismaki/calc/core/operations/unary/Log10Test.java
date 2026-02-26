package com.francoismaki.calc.core.operations.unary;

import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.operations.unary.Log10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Log10Test {
    @Test
    void TestLog10Positivo(){
        Expression log100 = new Log10(new Constant(100));
        assertEquals(2.0, log100.evaluate(), 0.0001);

        Expression log10 = new Log10(new Constant(10));
        assertEquals(1.0, log10.evaluate(), 0.0001);
    }

    @Test
    void TestLog10CeroNegativo(){
        Expression logCero = new Log10(new Constant(0));
        assertThrows(ArithmeticException.class, () -> {
            logCero.evaluate();
        });

        Expression logNegativo = new Log10(new Constant(-1));
        assertThrows(ArithmeticException.class, () -> {
            logNegativo.evaluate();
        });
    }
}
