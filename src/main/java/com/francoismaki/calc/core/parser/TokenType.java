package com.francoismaki.calc.core.parser;

public enum TokenType {
    NUMBER,         //  -inf, ..., -55, ..., 0, ..., 9500, +inf
    OPERATOR,      //  +, -, *, /
    FUNCTION,       //  sin, cos, tan, log, ln, sqrt
    PAREN_LEFT,     //  (
    PAREN_RIGHT,    //  )
}
