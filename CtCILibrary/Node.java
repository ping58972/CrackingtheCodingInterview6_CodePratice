package CtCILibrary;

public class Node{
    public Node next = null;
    public int data;
    public int length;
    public Node head;
    public Node tail;
    public Node(){}
    public Node(int d){
        data = d;
        length = 1;
        head = this;
        // tail = head;
        // tail = this;
    }
    public void addNode(Node newNode){
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = newNode;
    }
    public void addToHead(int d){
        Node h = new Node(d);
        Node t = this;
        h.next = t;
        // head = h;
        // this = h;
    }
    public void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        length++;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
        // tail = end;
    }
    public Node remove(Node head, int d){
        Node n = head;
        if(n.data == d){
            length--;
            return head.next;
        }
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
                length--;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}