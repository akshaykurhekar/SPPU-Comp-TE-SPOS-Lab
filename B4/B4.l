                              GROUP B
                          ASSIGNMENT NO.4
%{
#include<stdio.h>
#include "y.tab.h"
%}

%%
int|float|char|string   return BUILTIN;
new   return NEW;
"["   return OPEN_SQ;
"]"   return CLOSE_SQ;
"="   return EQ;
","   return COMMA;
";"   return SC;

[a-zA-Z]+[a-zA-Z0-9]*   return ID;
[0-9]+     return NUM;
\n      return 0;
%%
