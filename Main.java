import java.util.*;
public class Main {
    public static void main(String [] args){
        // chapter1_Array_Stringt();
        chapter2_LinkedList();    
    }
    // public static void chapter1_Array_Stringt(){
    //    boolean b = Chapter1_Array_String.isUnique_solution("Striign");
    //    boolean c = Chapter1_Array_String.checkPermutation_Ping("stur", "stru");
    //    String result = Chapter1_Array_String.urLify("Mr John Smith     ");
    //    boolean pp = Chapter1_Array_String.palindromePermutation("Tact Coa");
    //    boolean pp = Chapter1_Array_String.oneAway("pales", "bakes");
    //    String pp = Chapter1_Array_String.stringCompression("aabcccccaaa");
    // int m[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    //    Chapter1_Array_String.rotateMatrix(m);
    //     for(int i=0; i<m.length; i++){
    //         for(int j=0; j<m[i].length; j++){
    //             System.out.print(m[i][j] +" ");
    //         }
    //         System.out.println();
    //     }
    // int m[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,0,11,12},{13,14,0,16}};
    //    Chapter1_Array_String.zeroMatrix(m);
    //     for(int i=0; i<m.length; i++){
    //         for(int j=0; j<m[i].length; j++){
    //             System.out.print(m[i][j] +" ");
    //         }
    //         System.out.println();
    //     }

    // boolean pp = Chapter1_Array_String.isSubstringRotation("waterbottle", "bottlewater");
    // }
    public static void chapter2_LinkedList(){

        // Node node = new Node(0);
        // node.appendToTail(1);
        // node.appendToTail(7);
        // node.appendToTail(2);
        // node.appendToTail(9);
        // node.appendToTail(3);
        // node.appendToTail(3);
        // node.appendToTail(2);
        // node.appendToTail(8);
        // node.appendToTail(2);
        // node.appendToTail(4);
        // node.appendToTail(5);
        // node.appendToTail(4);
        // node.appendToTail(1);
        // node.remove(node, 2);
        // Node n = Chapter2_LinkedList.removeDups(node);
        // Chapter2_LinkedList.deleteDups_HashSet(node);
        
        // Node n = Chapter2_LinkedList.kth_last(node, 2);
        // Node n = Chapter2_LinkedList.nthToLast(node, 2);
        // Chapter2_LinkedList.deleteMiddleNode(node);
        // Node n = Chapter2_LinkedList.partition_linkedList(node, 5);

        // Node n1 = new Node(7);
        // n1.appendToTail(3);
        // n1.appendToTail(6);
        // Node n2 = new Node(1);
        // n2.appendToTail(9);
        // n2.appendToTail(3);
        // n2.appendToTail(9);
        // n2.appendToTail(2);
        // n2.appendToTail(2);
        // n2.appendToTail(6);
        // n2.appendToTail(5);
        // Node n = Chapter2_LinkedList.sumLists(n1, n2);
        // Node n = Chapter2_LinkedList.sumLists_reverse(n1, n2);
        // while( n != null){
        //     System.out.println(n.data);
        //     n = n.next;
        // }

        Node n = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        // LinkedList<Node> l = new LinkedList<Node>();
        // l.add(n);
        // l.add(n1);
        // l.add(n2);
        // l.add(n3);
        // // l.add(n2);
        // l.add(n1);
        // l.add(n);
        // Iterator<Node> itr = l.listIterator();
        // while(itr.hasNext()){
        //     System.out.println(itr.next().data);
        // }
        // boolean b = Chapter2_LinkedList.palindrome(l);
        // System.out.println(b);
        Node h1 = new Node(-1);
        h1.addNode(n);
        h1.addNode(n2);
        h1.addNode(n4);
        h1.addNode(n5);
        h1.addNode(n6);
        h1.addNode(n7);
      while( h1 != null){
            System.out.println(h1.data);
            h1 = h1.next;
        }
        
        Node h2 = new Node(-2);
        h2.addNode(n1);
        h2.addNode(n3);
        h2.addNode(n4);
        h2.addNode(n5);
        h2.addNode(n6);
        h2.addNode(n7);
      while( h2 != null){
            System.out.println(h2.data);
            h2 = h2.next;
        }
        // Node d = Chapter2_LinkedList.intersectingLinkedLists(h1, h2);

   
    }
}