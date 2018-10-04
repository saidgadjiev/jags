/*
    1 + 2 * 3 - 5 / 2
*/

grammar calculator;

expression
    : multExpression ('-' | '+'  multExpression) *
    ;

multExpression
    : atom ('*' | '/' atom) *
    ;

atom
    : NUMBER ('^' NUMBER) ?
    | '(' expression + ')'
    ;

NUMBER
    : ('1' .. '9') +
    ;