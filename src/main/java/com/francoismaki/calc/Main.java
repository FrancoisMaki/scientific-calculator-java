package com.francoismaki.calc;

import com.francoismaki.calc.api.CalculatorController;
import com.francoismaki.calc.core.ast.Constant;
import com.francoismaki.calc.core.ast.Expression;
import com.francoismaki.calc.core.operations.binary.Addition;
import com.francoismaki.calc.core.operations.binary.Multiplication;
import com.francoismaki.calc.core.parser.Parser;
import com.francoismaki.calc.core.parser.Token;
import com.francoismaki.calc.core.parser.Tokenizer;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.List;

public class Main {
    static void main(String[] args) {
        var app = Javalin.create(
                config -> {
                        //Evita bloqueo de puerto cerrado
                        config.bundledPlugins.enableCors(cors -> cors.addRule(it -> it.anyHost()));
                        //Mostrar front
                        config.staticFiles.add("/public", Location.CLASSPATH);
                    }
                )
                .start(7000);

        app.post("/calculate", CalculatorController::calculate);

        System.out.println("Servidor levantado");
        System.out.println("Esperando algo xd");
    }
}
