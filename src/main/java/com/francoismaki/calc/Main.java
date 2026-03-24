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
    static void main() {
        String ecuacion = "((3 * 1 + 5) * (4 + 2)) + 2";
        //String ecuacion = "(3 * 1 + 5 * 4 + 2) + 2";
        System.out.println("Ecuación Original: " + ecuacion);
        //  ((3 * 1 + 5) * (4 + 2)) + 2   -->     3 1 * 5 + 4 2 + * 2 +
        //  (3 * 1 + 5 * 4 + 2) + 2       -->     3 1 * 5 4 * + 2 + 2 +

        Tokenizer tokenizer = new Tokenizer(ecuacion);
        List<Token> tokens = tokenizer.tokenize();

        Parser parser = new Parser();
        List<Token> rpnTokens = parser.parseToRPN(tokens);

        System.out.println("Orden RPN:");
        for (Token token : rpnTokens) {
            System.out.print(token.getValue() + " ");
        }
    }
}
