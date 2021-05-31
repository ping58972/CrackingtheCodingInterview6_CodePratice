import java.util.HashSet;
import java.util.Stack;
import java.util.LinkedList;
import java.util.*;
public class Chapter2_LinkedList{
    // Qestion2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
    public static Node removeDups_(Node n){
        int [] arr = new int[100];
        Node head = n;
        while(n != null){
            arr[n.data]++;
            n = n.next;
        }
        n = head;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>1){
                for(int j=0; j<arr[i]-1; j++){
                    n.remove(n,i);
                }
            }
        }
        return n;
    }
    //How would you solve this problem if a temporary buffer is not allowed?
    public static Node removeDups(Node head){
        Node n = head;
        while( n != null){
            Node n1 = n;
            while(n1.next != null){
                if(n1.next.data == n.data){
                    n1.next = n1.next.next;
                } else{
                    n1 = n1.next;
                }
            }
            n = n.next;
        }
        return head;
    }
    //Delete Dups with HashSet
    public static void  deleteDups_HashSet(Node n) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node previous = null;
        while(n != null) {
            if(set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
    // Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
    public static Node kth_first(Node node, int kth) {
        Node n = node;
        int size =0;
        int i =0;
        Node point = null;
        while(n != null) {
            if(size == kth){
                point = n;
                i = size;
            }
            size++;
            n = n.next;
        }
        point.length = size - i;
        return point;
    }
    public static Node kth_last(Node node, int kth){
        int [] i = new int [1];
        i[0] = 0;
        return kth_last(node, kth, i);
    }
    private static Node kth_last(Node node, int kth, int [] i) {
        if(kth == 0){
                kth = 1;
            }
        if(node != null){
            Node n = kth_last(node.next, kth, i);
            i[0]++;
            
            if(kth == i[0]){
                // System.out.println("return kth and i = " + kth);
                return node;
            } 
            // System.out.println("return i = " + i[0]);
            return n;
        }
            return null;
    }
    public static Node nthToLast(Node node, int kth){
        Node p1 = node;
        Node p2 = node;
        for(int i=0; i<kth; i++){
            if(p1 == null) return null;
            p1 = p1.next;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
    // Question 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
    // the first and last node, not necessarily the exact middle) of a singly linked list, 
    // given only access to that node.
    public static boolean deleteMiddleNode(Node node){
        if(node == null || node.next == null) return false;
        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;        
    }

    // Question 2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less 
    // than x come before all nodes greater than or equal to x. lf x is contained within the list, 
    // the values of x only need to be after the elements less than x (see below). 
    // The partition element x can appear anywhere in the "right partition"; 
    // it does not need to appear between the left and right partitions.
    public static Node partition_linkedList_(Node head, int partition){
        Node n = head;
        Node left = null;
        Node leftHead = null;
        Node right = null;
        Node rightHead = null;
        while(n != null){
            if(n.data < partition){
                if( left == null){
                    left = new Node(n.data);
                    leftHead = left;
                } else {
                left.next = new Node(n.data);
                left = left.next;
                }
            } else if(n.data >= partition){
                if(right == null){
                    right = new Node(n.data);
                    rightHead = right;
                } else {
                    right.next = new Node(n.data);
                right = right.next;
                }
            }
            n = n.next;
        }
        left.next = rightHead;
    return leftHead;
    }
    public static Node partition_linkedList(Node node, int partition){
        Node head = node;
        Node tail = node;
        while(node != null){
            Node next = node.next;
            if(node.data < partition){
                // Insert node at head.
                node.next = head;
                head = node;
            } else {
                // Insert node at tail.
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        // The head has chaged, so we need to return it to the user.
        return head;
    }    

/****************Question 2.5***********************/
    // Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
    // Output: 9 -> 1 -> 2. That is, 912.
    public static Node sumLists(Node n1, Node n2){
        Node n = new Node();
        n.next = new Node();
        Node h1 = n1;
        Node h2 = n2;
        while(n1.next != null || n2.next != null){
            if(n1.next == null){
                Node temp = new Node(0);
                Node t = h1;
                temp.next = t;
                h1 = temp;
            } else{
                n1 = n1.next;
            }
            if(n2.next == null){
                Node temp2 = new Node(0);
                Node t2 = h2;
                temp2.next = t2;
                h2 = temp2;
            } else {
                n2 = n2.next;
            }
        }
        sumLists(n, h1, h2);
        n = deleteFirstZero(n);
        return n;
    }
    public static void sumLists(Node n, Node h1, Node h2){
        if(h1.next != null){ 
        n.next.next = new Node(0);      
        sumLists(n.next, h1.next, h2.next);
        }
        int x = h1.data + h2.data + n.next.data;
        n.next.data = x % 10;
        n.data = x/10; 
    }
    public static Node deleteFirstZero(Node n){
        if(n.data == 0){
            return n.next;
        }
        return n;
    }
    
    // Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .That is,617 + 295.
    // Output: 2 -> 1 -> 9. That is, 912.
    public static Node sumLists_reverse(Node n1, Node n2){
        Node n = new Node();
        n.next = new Node();
        sumLists_reverse(n, n1, n2);
        deleteLastZero(n);
        return n;
    }
    public static void sumLists_reverse(Node n, Node n1, Node n2){
        int d = n1.data + n2.data + n.data;
        n.data = d % 10;
        n.next = new Node(d/10);
        if(n1.next != null || n2.next != null){
            if(n1.next == null){
                n1.next = new Node(0);
            } else if(n2.next == null){
                n2.next = new Node(0);
            }
            sumLists_reverse(n.next, n1.next, n2.next);
        } 
    }
    public static void deleteLastZero(Node n){
        while(n.next.next != null){
            n = n.next;
        } 
        if(n.next.data == 0){
            n.next = null;
        }
    }
    /***********************************************/

    // Qestion 2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
    public static boolean palindrome(LinkedList<Node> list) {
        Stack<Node> stack = new Stack<Node>();
        stack.addAll(list);
        while(!stack.isEmpty()){
            if(stack.pop() != list.pop())
                return false;
        }
        return true;
    } 
    // public static boolean palindrome(LinkedList<Node> list) {
    //     Iterator<Node> itr = list.listIterator();
        
    //     return palindrome_recursive(list, itr, list.size());
    // }
    // public static boolean palindrome_recursive(LinkedList<Node> list, Iterator<Node> itr, int i){
    //     Node n = null;
    //     if(i != list.size()/2){
    //         n = itr.next();
    //         palindrome_recursive(list, itr, i--);
    //     }
    //     if(list.pop() != n)
    //         return false;
    //     return true;
    // }

    //Intersection: Given two (singly) linked lists, determine if the two lists intersect. 
    // Return the intersecting node. Note that the intersection is defined based on reference, 
    // not value. That is, if the kth node of the first linked list is the exact same node 
    // (by reference) as the jth node of the second linked list, then they are intersecting.
    public static Node intersectingLinkedLists(Node n1, Node n2){
        Node h1 = n1;
        Node h2 = n2;
        Node p = null;
        while(h1.next != null || h2.next != null){
            if(h1 == h2){
                p = h1;
                break;
            }
            if(h1.next != null){

            h1 = h1.next;
            } else if (h2.next != null){

            h2 = h2.next;
            }
        }
        System.out.println(p.data);
        return null;
 
    } 
}

class Node{
    Node next = null;
    int data;
    int length;
    Node head;
    // Node tail;
    public Node(){}
    public Node(int d){
        data = d;
        // length = 1;
        head = this;
        // tail = this;
    }
    void addNode(Node newNode){
        
        this.next = newNode;
    }
    void addToHead(int d){
        Node h = new Node(0);
        Node t = head;
        h.next = t;
        head = h;
    }
    void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        length++;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
        // tail = end;
    }
    Node remove(Node head, int d){
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