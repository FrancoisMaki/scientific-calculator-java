package com.francoismaki.calc.api;

import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.parser.Parser;
import com.francoismaki.calc.core.parser.Token;
import com.francoismaki.calc.core.parser.Tokenizer;
import io.javalin.http.Context;

import java.util.List;
import java.util.Map;

public class CalculatorController {

    private static final Parser parser = new Parser();

    public static void calculate(Context context){
        try {
            Map<String, String> body = context.bodyAsClass(Map.class);
            String input = body.get("equation");

            Tokenizer tokenizer = new Tokenizer(input);
            List<Token> token = tokenizer.tokenize();
            List<Token> rpn = parser.parseToRPN(token);
            Expression expression = parser.buildAST(rpn);

            double result = expression.evaluate();

            context.json(Map.of("result", result));
        }catch (Exception e){
            context.status(400).json(Map.of("error", e.getMessage()));
        }
    }

}
