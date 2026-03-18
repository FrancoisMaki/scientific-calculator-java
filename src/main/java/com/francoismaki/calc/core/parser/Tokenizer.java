package com.francoismaki.calc.core.parser;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final String input;
    private int pos = 0;

    public Tokenizer(String input) {
        this.input = input;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        while (pos < input.length()) {
            char current = input.charAt(pos);

            // 1. Ignoramos los espacios en blanco
            if (Character.isWhitespace(current)) {
                pos++;
            }

            // 2. Leer los numeros
            else if (Character.isDigit(current) || current == '.') {
                tokens.add(new Token(TokenType.NUMBER, readNumber()));
            }

            // 3. Leer funciones
            else if (Character.isLetter(current)) {
                tokens.add(new Token(TokenType.FUNCTION, readWord()));
            }

            // 4. Leer Operadores
            else if (isOperator(current)){
                tokens.add(new Token(TokenType.OPERATOR, String.valueOf(current)));
                pos++;
            }

            // 5. Manejo de Parentesis
            else if (current == '('){
                tokens.add(new Token(TokenType.PAREN_LEFT, "("));
                pos++;
            }
            else if (current == ')'){
                tokens.add(new Token(TokenType.PAREN_RIGHT, ")"));
                pos++;
            }

            // 6. Manejo de errores
            else {
                throw new IllegalArgumentException("Caracter matematico no reconocido");
            }
        }
        return tokens;
    }

    private String readNumber(){
        StringBuilder sb = new StringBuilder();
        while (pos < input.length() && (Character.isDigit(input.charAt(pos)) || input.charAt(pos) == '.')){
            sb.append(input.charAt(pos));
            pos++;
        }
        return sb.toString();
    }

    private String readWord(){
        StringBuilder sb = new StringBuilder();
        while (pos < input.length() && Character.isLetter(input.charAt(pos))){
            sb.append(input.charAt(pos));
            pos++;
        }
        return sb.toString();
    }

    private boolean isOperator(char c){
        return c == '+'
                || c == '-'
                || c == '/'
                || c == '*'
                || c == '^';
    }



}
