package com.francoismaki.calc;

import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.operations.binary.Addition;
import com.francoismaki.calc.core.operations.binary.Multiplication;
import com.francoismaki.calc.core.parser.Parser;
import com.francoismaki.calc.core.parser.Token;
import com.francoismaki.calc.core.parser.Tokenizer;

import java.util.List;

public class Main {
    static void main(String[] args) {
        String ecuacion = "sin(0) + cos(0)";

        Tokenizer tokenizer = new Tokenizer(ecuacion);
        List<Token> tokens = tokenizer.tokenize();

        Parser parser = new Parser();
        List<Token> rpn = parser.parseToRPN(tokens);

        Expression expression = parser.buildAST(rpn);

        double res = expression.evaluate();

        System.out.println("Input " + ecuacion);
        System.out.println("Resultado " + res);
        System.out.println("RPN " );
        for (Token t : rpn){
            System.out.print(t.getValue() + " ");
        }
    }
}
