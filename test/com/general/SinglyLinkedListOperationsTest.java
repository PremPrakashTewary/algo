package com.general;

import org.junit.Test;

public class SinglyLinkedListOperationsTest
{
    @Test
    public void testAddTwoList()
    {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(7);

        // creating first list
        head1.next = new SinglyLinkedListNode(5);
        head1.next.next = new SinglyLinkedListNode(9);
        head1.next.next.next = new SinglyLinkedListNode(4);
        head1.next.next.next.next = new SinglyLinkedListNode(6);
        System.out.println("First List is ");
        SinglyLinkedListOperations.printList(head1);

        // creating seconnd list
        SinglyLinkedListNode head2 = new SinglyLinkedListNode(8);
        head2.next = new SinglyLinkedListNode(4);
        System.out.println("\nSecond List is ");
        SinglyLinkedListOperations.printList(head2);

        // add the two lists and see the result
        SinglyLinkedListNode rs = SinglyLinkedListOperations.addTwoList(head1, head2);
        System.out.println("\nResultant List is ");
        SinglyLinkedListOperations.printList(rs);

        SinglyLinkedListNode newnode = SinglyLinkedListOperations.retainMDeleteN(rs, 2, 1);
        System.out.println("\nretainMDeleteN ");
        SinglyLinkedListOperations.printList(newnode);
    }
}
