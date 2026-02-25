package com.francoismaki.calc.core.operations.binary;

import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.operations.binary.Addition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {
    @Test
    void testSumaDeDosConstantes(){
        Expression five = new Constant(5);
        Expression ten = new Constant(10);
        Expression add = new Addition(five, ten);

        double answer = add.evaluate();

        assertEquals(15.0, answer, 0.0001);

    }
}
