package com.francoismaki.calc;

import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.operations.binary.Addition;
import com.francoismaki.calc.core.operations.binary.Multiplication;

public class Main {
    static void main() {
        Expression five = new Constant(5);
        Expression ten = new Constant(10);
        Expression three = new Constant(3);

        Expression add = new Addition(five, ten);

        Expression completeOperation = new Multiplication(add, three);

        double answer = completeOperation.evaluate();

        System.out.println("--- Test de Calculadora Científica ---");
        System.out.println("Expresión: (5 + 10) * 3");
        System.out.println("Resultado: " + answer);
    }
}
