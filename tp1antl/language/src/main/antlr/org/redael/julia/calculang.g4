//java -cp antlr-4.8-complete.jar org.antlr.v4.tool ne marche pas

grammar calculang;

/* * Parser Rules */
program: statement * EOF;
statement: expression OPER expression *  ;
//statement: expression * '=' expression*  ; //I set it for our Devoir
expression:  terme | terme OPER terme *  ;
terme: INT | FLOAT | DIGIT | idOneLetter |idLong;
idOneLetter:  X;
idLong:IDENTIFIER;

/* * Lexer Rules */
WS : [ \t\r\n\f]+ -> skip;
DIGIT: '0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9';
INT: DIGIT+;
FLOAT: INT '.' INT;

X:[a-z] | [A-Z];
IDENTIFIER:  X (X | INT)*;
OPER:ADD|DIV|SUB|MUL;

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
