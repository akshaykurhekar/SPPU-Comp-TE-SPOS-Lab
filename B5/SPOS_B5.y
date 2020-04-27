/*Write a program using YACC specifications 
to implement syntax analysis phase of compiler to recognize 
simple and compound sentences given in input file.*/
%{
#include"stdio.h"
%}
%token COMPOUND WORD DOT
%%
S1	: S S1
	| S
	;
S	: WORD_LIST COMPOUND WORD_LIST DOT	{printf("Above statement is a compound statement.\n");}
	| WORD_LIST DOT			{printf("Above statement is a simple statement.\n");}
	;
WORD_LIST: WORD WORD_LIST 		
	| WORD
	;
%%
extern FILE *yyin;
int main()
{
	yyin=fopen("sample.txt","r");
	yyparse();
	return 0;
}
int yyerror()
{
	return 0;
}

/*start 	: start "\n" S
	|	S
	; 
S 	: WL COMPOUND WL "."	{printf("\nIt is compund sentence.");}
	;

WL 	: WORD WL
	| WORD
	;

(""[aA][nN][dD]"")|(""[oO][rR]"")|(""[bB][uU][tT]"") 	{return COMPOUND;}
*/
