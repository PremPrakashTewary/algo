package com.general;

/**
 * Given a string that contains ternary expressions.
 * The expressions may be nested, task is convert the given ternary expression to a binary Tree.
 *
 * Examples
 *
 * Input :  string expression =   a?b:c
 * Output :        a
 *               /  \
 *              b    c
 *
 * Input : expression =  a?b?c:d:e
 * Output :     a
 *            /  \
 *           b    e
 *         /  \
 *        c    d
 */
public class TernaryExpressionExpression
{
    private static class Node
    {
        char data;
        Node left;
        Node right;

        public Node(char data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static Node convertExpression(char[] expression, int i)
    {
        if ( i >= expression.length )
        {
            return null;
        }
        Node root = new Node( expression[i] );
        ++i;
        if ( i < expression.length && expression[i] == '?' )
        {
            root.left = convertExpression( expression, i + 1 );
        }
        else if ( i < expression.length )
        {
            root.right = convertExpression( expression, i + 1 );
        }
        return root;
    }

    private static void printTree(Node root)
    {
        if ( root == null )
        {
            return;
        }
        System.out.print( root.data + " " );
        printTree( root.left );
        printTree( root.right );
    }

    public static void main( String[] args )
    {
        String exp = "a?b?c:d:e";
        char[] expression=exp.toCharArray();
        Node root = convertExpression(expression, 0);
        printTree(root) ;
    }
}
