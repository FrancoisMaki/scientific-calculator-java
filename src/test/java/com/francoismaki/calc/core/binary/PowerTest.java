package com.francoismaki.calc.core.binary;

import com.francoismaki.calc.core.Constant;
import com.francoismaki.calc.core.Expression;
import com.francoismaki.calc.core.operations.binary.Power;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerTest {
    @Test
    void testPotenciaDeConstantes(){
        Expression five = new Constant(5);
        Expression two = new Constant(2);
        Expression power = new Power(five, two);

        double answer = power.evaluate();

        assertEquals(25.0, answer, 0.0001);

    }
}
