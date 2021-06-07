// parser

grammar Nice;

program: statement* EOF;

statement: greeting | introduction ;
greeting: 'hello ' ID;
introduction: 'My name is ' ID;

// lexer

WS : [ \t\r\n\f]+ -> skip;
LETTER : [A-Z] | [a-z];
ID : LETTER+;