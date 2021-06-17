package chapters;

import java.util.*;
// import CtCILibrary.*;

public class Chapter4_Trees_Graphs{
    public static void all(){
        // Node n = new Node("n");
        // Node n1 = new Node("n1");
        // Node n2 = new Node("n2");
        // Node n3 = new Node("n3");
        // Node n4 = new Node("n4");
        // Node n5 = new Node("n5");
        // Node n6 = new Node("n6");
        // Node n7 = new Node("n7");
        // n.setChildren(n1);
        // n.setChildren(n2);
        // n1.setChildren(n3);
        // n2.setChildren(n3);
        // n3.setChildren(n4);
        // n3.setChildren(n5);
        // n4.setChildren(n6);
        // n5.setChildren(n7);
        // n6.setChildren(n5);
        // n6.setChildren(n3);
        // boolean b = isRouteBetweenNodes_BFS(n, n7);
        // // isRouteBetweenNodes_DFS(n, n7);
        // System.out.println(b);

        // BSTNode n1 = new BSTNode(1, null, null);
        // BSTNode n3 = new BSTNode(3, null, null);
        // BSTNode n5 = new BSTNode(5, null, null);
        // BSTNode n7 = new BSTNode(7, null, null);
        // BSTNode n2 = new BSTNode(2, n1, n3);
        // BSTNode n6 = new BSTNode(6, n5, n7);
        // BSTNode n4 = new BSTNode(4, n2, n6);
        // // printBSTNode(n4);
        // print_BFS(n4);
        // BSTNode nn = new BSTNode(4, null, null);
        // createBSTNode(nn, 2);
        // createBSTNode(nn, 1);
        // createBSTNode(nn, 3);
        // createBSTNode(nn, 6);
        // createBSTNode(nn, 5);
        // createBSTNode(nn, 7);
        // print_BFS(nn);
        // printBSTNode(nn);
        // System.out.println(nn.right.left.data);
        int [] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        // BSTNode n = createMinimalTree(array);
        BSTNode n = createMinimalBST(array);
        // print_BFS(n);
        // System.out.println();
        // printBSTNode(n);
        ArrayList<LinkedList<BSTNode>> dls = listOfDepths(n);
        for(LinkedList<BSTNode> ds: dls){
            for(BSTNode d: ds){
                System.out.print(" "+ d.data);
            }
            System.out.println();
        }
        // System.out.println();
        // System.out.println(n.right.right.data);
    }

    // Question 4.3 List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
    // at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
    public static ArrayList<LinkedList<BSTNode>> listOfDepths(BSTNode n){
        ArrayList<LinkedList<BSTNode>> allb = new ArrayList<LinkedList<BSTNode>>();
        // listOfDepths_DFS(n, allb, 0);
        // return allb;
        return listOfDepths_BFS(n);
    }
    private static void listOfDepths_DFS(BSTNode n, ArrayList<LinkedList<BSTNode>> allb, int level ){
        if(n == null) return;
        LinkedList<BSTNode> l = null;
        if(allb.size()== level){
            l = new LinkedList<BSTNode>(); 
            allb.add(l);
        } else {
            l = allb.get(level);
        }
        l.add(n);
        listOfDepths_DFS(n.left, allb, level+1);
        listOfDepths_DFS(n.right, allb, level+1);
    }
    private static ArrayList<LinkedList<BSTNode>> listOfDepths_BFS(BSTNode bstNode){
     ArrayList<LinkedList<BSTNode>> allb = new ArrayList<LinkedList<BSTNode>>();
        LinkedList<BSTNode> current = new LinkedList<BSTNode>();
        // visit the root or bstNode.
        if(bstNode != null){
            current.add(bstNode);
        }
        while(current.size() > 0) {
            allb.add(current); // add previous level.
            LinkedList<BSTNode> parents = current; // go to next level.
            current = new LinkedList<BSTNode>();
            for(BSTNode node: parents){
                // visit the children.
                if(node.left != null){
                    current.add(node.left);
                }
                if(node.right != null){
                    current.add(node.right);
                }
            }
        }
        return allb;
    }


  
    // Question 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
    // to create a binary search tree with minimal height.
    public static BSTNode createMinimalTree(int [] sortedArray){
        int index = sortedArray.length / 2;
        
        int data = sortedArray[index];
        
        BSTNode  bstNode = new BSTNode(data, null, null);
        int [] leftArray = Arrays.copyOfRange(sortedArray, 0, index);
        int [] rightArray = Arrays.copyOfRange(sortedArray, index +1, sortedArray.length);
        createMinimalTree(leftArray, rightArray, bstNode);
        
        return bstNode;
    }
    private static void createMinimalTree(int [] leftArray, int [] rightArray,  BSTNode bstNode){
        if(leftArray.length < 1 && rightArray.length < 1 ) return;
        if(leftArray.length > 0){
            createBSTNode(bstNode, leftArray[leftArray.length / 2]);
            int [] newLeftArray = Arrays.copyOfRange(leftArray, 0, leftArray.length / 2);
            int [] newRightArray = Arrays.copyOfRange(leftArray, leftArray.length / 2 + 1, leftArray.length);
            createMinimalTree(newLeftArray, newRightArray, bstNode);
        }
        if(rightArray.length > 0){
            createBSTNode(bstNode, rightArray[rightArray.length / 2]);
            int [] newLeftArray1 = Arrays.copyOfRange(rightArray, 0, rightArray.length / 2);
            int [] newRightArray1 = Arrays.copyOfRange(rightArray, rightArray.length / 2 + 1, rightArray.length);
            createMinimalTree(newLeftArray1, newRightArray1, bstNode);
        }
    }

    public static void createBSTNode(BSTNode root, int data){
        if( root == null){
            return;
        } 
        if( data > root.data){
            if( root.right == null){
                root.right = new BSTNode(data, null, null);
            } else {
                createBSTNode(root.right, data);
            }
        } else {
            if( root.left == null){
                root.left = new BSTNode(data, null, null);
            } else {
                createBSTNode(root.left, data);
            }
        }
        
    }

    public static void printBSTNode(BSTNode root){
        if(root == null) return;
        printBSTNode(root.left);
        System.out.print(" "+root.data);
        printBSTNode(root.right);
    }
    private static void print_BFS(BSTNode root){
        Queue<BSTNode> q = new LinkedList<BSTNode>();
        root.visited = true;
        q.add(root); // add to the end of queue.
        while(!q.isEmpty()){
            BSTNode r = q.remove(); // Remove from the front of the queue.
            visit(r);
            if(r.left != null) {
                BSTNode l = r.left;
                if(l.visited == false){
                    l.visited  = true;
                    q.add(l);
                }
            }  
            if (r.right != null ){
                    BSTNode ri = r.right;
                    if (ri.visited == false){
                    ri.visited  = true;
                    q.add(ri);
                }
            }
        }
    }
    private static void visit(BSTNode n){
        System.out.print(" "+n.data);
    }
   
    // Solution from Book.
    public static BSTNode createMinimalBST(int array[]){
        return createMinimalBST(array, 0, array.length - 1);
    }
    private static BSTNode createMinimalBST(int array[], int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        BSTNode n = new BSTNode(array[mid], null, null);
        n.left = createMinimalBST(array, start, mid -1);
        n.right = createMinimalBST(array, mid +1, end);
        return n;
    }
 /***************************************************************** */
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

class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;
    public boolean visited = false;
    public BSTNode(int data, BSTNode left, BSTNode right){
        this.data = data;
        this.left = left;
        this.right = right;
        this.visited = false;
    }
    public BSTNode(){}
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
