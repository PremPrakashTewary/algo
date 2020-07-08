package com.general;

import java.util.Stack;

public class BalancedBrackets
{
    private static boolean matchBrackets(Stack<Character> stack, Character closingBracket)
    {
        boolean match = false;
        Character gotChar = stack.pop();
        if (closingBracket == ']' )
        {
            if (gotChar == '[' )
            {
                match = true;
            }
        }
        else if ( closingBracket == '}' )
        {
            if ( gotChar == '{' )
            {
                match = true;
            }
        }
        else if ( closingBracket == ')' )
        {
            if ( gotChar == '(' )
            {
                match = true;
            }
        }
        return match;
    }

    //Check for balanced parentheses in an expression
    //Given an expression string exp , write a program to examine whether the pairs and the orders of
    // “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
    // For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
    private static boolean balancedBracket(String input)
    {
        boolean balanced = true;
        Stack<Character> stack = new Stack<>();
        char[] charArr = input.toCharArray();
        stack.push( charArr[0] );
        for (int i = 1; i < charArr.length; i++ )
        {
            if ( charArr[i] == '[' || charArr[i] == '{' || charArr[i] == '(' )
            {
                stack.push( charArr[i] );
            }
            else
            {
                if ( !matchBrackets( stack, charArr[i] ) )
                {
                    balanced = false;
                }
            }
            if ( !balanced )
            {
                break;
            }
        }
        return balanced;
    }

    public static void main( String[] args )
    {
        String brackets = "[()]{}{[()()]()}";

        System.out.println( balancedBracket( brackets ) );

        System.out.println( balancedBracket( "[(])" ) );
    }
}
