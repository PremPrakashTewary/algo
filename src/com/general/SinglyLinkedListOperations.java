package com.general;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedListOperations
{

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head)
    {
        Set<Integer> set = new HashSet<>();
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode previous = null;
        while (current != null)
        {
            int value = current.val;
            if (set.add(value))
            {
                previous = current;
            }
            else
            {
                previous.next = current.next;
            }
            current = current.next;
        }
        return head;
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head, int k)
    {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode next = null;
        SinglyLinkedListNode prev = null;
        int count = 0;
        // reverse the first k elements in node
        while (count < k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null)
        {
            head.next = reverse(next, k);
        }
        return prev;
    }

    public static SinglyLinkedListNode addTwoList(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
    {
        SinglyLinkedListNode res = null;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode temp = null;
        int carry = 0;
        int sum = 0;
        while (head1 != null || head2 != null)
        {
            sum = carry + (head1 != null ? head1.val : 0)
                + (head2 != null ? head2.val : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new SinglyLinkedListNode(sum);
            if (res == null)
            {
                res = temp;
            }
            else
            {
                prev.next = temp;
            }
            prev = temp;
            if (head1 != null)
            {
                head1 = head1.next;
            }
            if (head2 != null)
            {
                head2 = head2.next;
            }
        }
        if (carry > 0)
        {
            temp.next = new SinglyLinkedListNode(carry);
        }
        return res;
    }

    public static SinglyLinkedListNode retainMDeleteN(SinglyLinkedListNode head, int m, int n)
    {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode temp = null;
        while (current != null)
        {
            for (int i = 1 ; i < m && current != null; i++)
            {
                current = current.next;
            }

            if (current == null)
            {
                return head;
            }

            temp = current.next;
            for (int i = 0; i < n && temp != null; i++)
            {
                temp = temp.next;
            }
            current.next = temp;
            current = temp;
        }
        return head;
    }

    public static void printList(SinglyLinkedListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args)
    {
        SinglyLinkedListNode head = new SinglyLinkedListNode(10);
        head.next = new SinglyLinkedListNode(12);
        head.next.next = new SinglyLinkedListNode(11);
        head.next.next.next = new SinglyLinkedListNode(11);
        head.next.next.next.next = new SinglyLinkedListNode(12);
        head.next.next.next.next.next = new SinglyLinkedListNode(11);
        head.next.next.next.next.next.next = new SinglyLinkedListNode(10);

        System.out.println("Linked list before removing duplicates :");
        printList(head);

        SinglyLinkedListNode uniqueSinglyLinkListNode = removeDuplicates(head);

        System.out.println("\nLinked list after removing duplicates :");
        printList(uniqueSinglyLinkListNode);

        SinglyLinkedListNode reverseNode = reverse(uniqueSinglyLinkListNode, 2);

        System.out.println("\nLinked list after reverse with 2 :");
        printList(reverseNode);
    }
}
class SinglyLinkedListNode
{
    int val;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int val)
    {
        this.val = val;
    }
}

