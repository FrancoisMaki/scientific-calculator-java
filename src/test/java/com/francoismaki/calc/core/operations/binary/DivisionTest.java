package com.francoismaki.calc.core.operations.binary;

import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.operations.binary.Division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionTest {
    @Test
    void testDivisionDeDosConstantes(){
        Expression five = new Constant(5);
        Expression ten = new Constant(10);
        Expression division = new Division(five, ten);

        double answer = division.evaluate();

        assertEquals(0.5, answer, 0.0001);

    }

    @Test
    void testDivisionPorCeroLanzaExcepcion(){
        Expression division = new Division(new Constant(10),
                                            new Constant(0));
        assertThrows(ArithmeticException.class, () -> {
            division.evaluate();
        });
    }
}
