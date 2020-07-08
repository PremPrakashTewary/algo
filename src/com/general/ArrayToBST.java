package com.general;

import java.util.Scanner;

public class ArrayToBST
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int tectCases = scanner.nextInt();
        for (int i = 0 ; i < tectCases; i++)
        {
            int len = scanner.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++)
            {
                arr[j] = scanner.nextInt();
            }
            int n = arr.length;
            if (n % 2 != 0)
            {
                n = n - 1;
            }
            preOrder(sortedArrayToBST(arr, 0 , n ));
            System.out.println();
        }
    }

    private static Node sortedArrayToBST(int[] arr, int low, int high)
    {
        if (low > high)
        {
            return null;
        }

        int mid = low+((high-low)/2);
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, low, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, high);
        return node;
    }

    static void preOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}

class Node
{
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
