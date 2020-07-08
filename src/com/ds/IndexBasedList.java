package com.ds;

public class IndexBasedList
{
    private Node head;
    private int size;

    private class Node
    {
        private int val;
        private Node next;

        public Node(int val)
        {
            this.val = val;
        }
    }

    public void addAtHead(int val)
    {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void addAtTail(int val)
    {
        if(size == 0)
        {
            addAtHead(val);
            return;
        }
        Node node = getAtIndex(size - 1);
        node.next = new Node(val);
        size++;
    }

    public int get(int index)
    {
        if(size ==0)
        {
            return -1;
        }
        Node node = getAtIndex(index);
        return node == null ? -1 : node.val;
    }

    public void addAtIndex(int index, int val)
    {
        if(index >= size)
        {
            return;
        }
        if(size == 0 || index == 0)
        {
            addAtHead(val);
            return;
        }
        Node curNode = getAtIndex(index-1);
        Node newNode = new Node(val);
        Node nextNode = curNode.next;
        curNode.next = newNode;
        newNode.next = nextNode;
        size++;
    }

    public void deleteAtIndex(int index)
    {
        if(index >= size)
        {
            return;
        }
        if(index == 0)
        {
            Node node = head.next;
            head = node;
            size--;
            return;
        }
        Node curNode = head;
        Node prevNode = head;
        for (int i = 0; i < index && curNode != null; i++)
        {
            prevNode = curNode;
            curNode = curNode.next;
        }
        if(null != curNode)
        {
            prevNode.next = curNode.next;
            size++;
        }
    }

    private Node getAtIndex(int index)
    {
        Node temp = head;
        for(int i = 0; temp != null && i < index ; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    public void print()
    {
        Node temp = head;
        while(null != temp)
        {
            System.out.println("The value is " + temp.val);
            temp = temp.next;
        }
    }

    public static void main( String[] args )
    {
        IndexBasedList indexBasedList = new IndexBasedList();
        indexBasedList.addAtHead(7);
        indexBasedList.addAtHead(2);
        indexBasedList.addAtHead(1);
        indexBasedList.addAtIndex(3, 0);
        indexBasedList.deleteAtIndex(2);
        indexBasedList.addAtHead(6);
        indexBasedList.addAtTail(4);
        indexBasedList.print();
        System.out.println("Get at 4 " + indexBasedList.get(4));
        indexBasedList.addAtHead(4);
        indexBasedList.addAtIndex(5, 0);
        indexBasedList.addAtHead(6);
        indexBasedList.print();
        System.out.println("Get at 1 " + indexBasedList.get(1));
    }
}
