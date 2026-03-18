package com.francoismaki.calc;

import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.operations.binary.Addition;
import com.francoismaki.calc.core.operations.binary.Multiplication;
import com.francoismaki.calc.core.parser.Token;
import com.francoismaki.calc.core.parser.Tokenizer;

import java.util.List;

public class Main {
    static void main() {
        String ecuacion = "35.5 + sin(90) * (2^4)";
        System.out.println("Generando la respuesta " + ecuacion);

        Tokenizer tokenizer = new Tokenizer(ecuacion);
        List<Token> tokens = tokenizer.tokenize();

        for (Token token : tokens){
            System.out.println(token);
        }
    }
}
