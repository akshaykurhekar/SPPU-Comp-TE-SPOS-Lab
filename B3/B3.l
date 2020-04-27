                              GROUP B
                          ASSIGNMENT NO.3
%{
#include <stdio.h>
int lines=0, words=0, c_letters=0, num=0, spl_char=0, total=0;
%}

%%
\n { lines++; words++;}
[\t ' '] words++;
[a-zA-Z] c_letters++;
[0-9] num++;
. spl_char;
%%

int main()
{
   yyin=fopen("sample.java","r");
   yylex();
   total=c_letters+num+spl_char;
   printf("This file contains...");
   printf("\n\t%d lines",lines);
   printf("\n\t%d words",words);
   printf("\n\t%d characters",c_letters);
   printf("\n\t%d digits",num);
   printf("\n\t%d special characters",spl_char);
   printf("\n\t%d characters",total);
   return 0;
}
int yywrap()
{
  return (1);
}


