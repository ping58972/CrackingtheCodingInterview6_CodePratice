package chapters;

import java.util.*;
// import CtCILibrary.*;

public class Chapter4_Trees_Graphs{
    public static void all(){
        Node n = new Node("n");
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        Node n4 = new Node("n4");
        Node n5 = new Node("n5");
        Node n6 = new Node("n6");
        Node n7 = new Node("n7");
        n.setChildren(n1);
        n.setChildren(n2);
        n1.setChildren(n3);
        n2.setChildren(n3);
        n3.setChildren(n4);
        n3.setChildren(n5);
        n4.setChildren(n6);
        n5.setChildren(n7);
        n6.setChildren(n5);
        n6.setChildren(n3);
        boolean b = isRouteBetweenNodes_BFS(n, n7);
        // isRouteBetweenNodes_DFS(n, n7);
        System.out.println(b);

    }

    // Question 4.1 Route Between Nodes: Given a directed graph, design an algorithm 
    // to find out whether there is a route between two nodes.
    public static void isRouteBetweenNodes_DFS(Node n1, Node n2){
        if(n1 == null ) return;
        if(n1.name.equals(n2.name)) {
            System.out.println("haha");
        }
        n1.visited = true;
        for (Node n: n1.children){
            if(n != null && n.visited == false){
                isRouteBetweenNodes_DFS(n, n2);
            }
        }
        // return false;
    }
    public static boolean isRouteBetweenNodes_BFS(Node n1, Node n2){
        Queue<Node> q = new LinkedList<Node>();
        n1.visited = true;
        q.add(n1); // add to the end of queue.
        while(!q.isEmpty()){
            Node r = q.remove(); // Remove from the front of the queue.
            if(r.name.equals(n2.name)) return true;
            for (Node n : r.children) {
                if(n != null && n.visited == false){
                    n.visited = true;
                    q.add(n);
                }
            }
        }
        return false;
    }
    // Depth First Search
    private static void search_DFS(Node root){
        if(root == null) return;
        visit(root);
        root.visited = true;
        for (Node n: root.children){
            if(n.visited == false){
                search_DFS(n);
            }
        }
    }
    // Breadth First Search
    private static void search_BFS(Node root){
        Queue<Node> q = new LinkedList<Node>();
        root.visited = true;
        q.add(root); // add to the end of queue.
        while(!q.isEmpty()){
            Node r = q.remove(); // Remove from the front of the queue.
            visit(r);
            for (Node n : r.children) {
                if(n.visited == false){
                    n.visited = true;
                    q.add(n);
                }
            }
        }
    }
    private static void visit(Node n){
        System.out.print(n);
    }
}

class Node {
    public String name;
    public boolean visited = false;
    public Node[] children;
    private int index;
    public Node(String name){
        this.name = name;
        children = new Node[10];
        index = 0;
    }
    public void setChildren(Node n){
        children[index] = n;
        index++;
    }
    @Override
    public String toString(){
        return "Name: "+ name;
    }
}
class Graph {
    public Node[] nodes;
}
