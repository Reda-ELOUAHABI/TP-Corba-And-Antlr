
grammar devoir;

/* * Parser Rules */
program: statement * EOF;
statement: expression OPER expression *  ;
expression:  terme | terme OPER terme *  ;
terme: INT | FLOAT | DIGIT;


/* * Lexer Rules */
WS : [ \t\r\n\f]+ -> skip;
DIGIT: '0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9';
INT: DIGIT+;
FLOAT: INT '.' INT;
OPER:ADD|MUL;

MUL: '*';

ADD: '+';

