%{
#include<stdio.h>
#include "y.tab.h"
%}

%token ID BUILTIN SC COMMA OPEN_SQ CLOSE_SQ EQ NUM NEW

%%
start  : BUILTIN varlist SC {printf("Declaration is valid");}
|  BUILTIN OPEN_SQ CLOSE_SQ ID EQ NEW BUILTIN OPEN_SQ NUM CLOSE_SQ SC {printf("Declaration is valid");}
|  varlist:varlist COMMA ID|ID;
%%

int yywrap()
{
return 1;
}
main()
{
  printf("\nEnter a statement:");
  yyparse();
}
yyerror(char *s)
{
fprintf(stderr,"%s\n",s);
}



