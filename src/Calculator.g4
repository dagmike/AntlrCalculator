/**
 * Define a grammar called Calculator
 */
grammar Calculator;

prog: stat+ ;

stat: expr  #exprStat
	| ID '=' expr  #assign
	;

expr: expr MUL expr #mul
	| expr DIV expr #div
	| expr ADD expr #add
	| expr SUB expr #sub
	| INT 			#int
	| ID 			#id
	| '(' expr ')' 	#parens
	;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
ID	: [a-zA-Z]+ ;
INT : [0-9]+ ;
WS  : [ \t\r\n]+ -> skip ;

