/*Write a program using YACC specifications to implement 
syntax analysis phase of compiler to recognize simple 
and compound sentences given in input file.*/
%{
#include"y.tab.h"
int flag=0;
%}
%%
(""[aA][nN][dD]"")|(""[oO][rR]"")|(""[bB][uU][tT]"") 		{return COMPOUND;}
[a-zA-Z]+	{return WORD;}
"."		return DOT;
\t|\n|" "	;					
.	return yytext[0];
%%
int yywrap()
{
	return 1;
}

