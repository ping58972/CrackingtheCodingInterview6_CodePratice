package chapters;

import java.util.*;
import java.lang.Math;
import CtCILibrary.*;

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
        // createBSTNode(nn, -1);
        // createBSTNode(nn, 1);
        // createBSTNode(nn, 3);
        // createBSTNode(nn, 6);
        // createBSTNode(nn, 5);
        // createBSTNode(nn, 7);
        // createBSTNode(nn, 10);
        // createBSTNode(nn, 10);
        // createBSTNode(nn, 0);
        // createBSTNode(nn, 0);
        // createBSTNode(nn, 0);
        // createBSTNode(nn, 18);
        // print_BFS(nn);
        // printBSTNode(nn);
        // System.out.println(nn.right.left.data);
        // int [] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        // BSTNode n = createMinimalTree(array);
        // BSTNode nn = createMinimalBST(array);
        // print_BFS(n);
        // System.out.println();
        // printBSTNode(n);
        // ArrayList<LinkedList<BSTNode>> dls = listOfDepths(nn);
        // for(LinkedList<BSTNode> ds: dls){
        //     for(BSTNode d: ds){
        //         System.out.print(" "+ d.data);
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // System.out.println(n.right.right.data);
        // int h = heightOfBST(n);
        // boolean b = isBSTBalance(nn);
        // boolean b = isBalanced(nn);
        // System.out.println(b);
        // int h = maxHeightBST(nn);
        // System.out.println(h);

        // int [] array = {1,2,3,4,5,6,7};
        // TreeNode n = TreeNode.createMinimalBST(array);
        // TreeNode n3 = n.find(3);
        // TreeNode successor = inOrderSuccessorBST(n3);
        // if(successor != null)
        // System.out.println(successor.data);
        // TreeNode n4 = n.find(4);
        // TreeNode nl = findLeftNode(n4);
        // System.out.println(nl.data);


        /*******Testing for Question 4.7 
        // Begining
        LinkedList<String> projects = new LinkedList<String>();
        String [] strs = {"a","b","c","d","e","f"};
        projects.addAll(Arrays.asList(strs));
        LinkedList<String []> dependencies = new LinkedList<String []>();
        String [] deps1 = {"a","d"};
        String [] deps2 = {"f","b"};
        String [] deps3 = {"b","d"};
        String [] deps4 = {"f","a"};
        String [] deps5 = {"d","c"};
        String [] deps6 = {"c","b"};
        dependencies.add(deps1);
        dependencies.add(deps2);
        dependencies.add(deps3);
        dependencies.add(deps4);
        dependencies.add(deps5);
        // dependencies.add(deps6);
        Graph g = new Graph();
        for(String str: projects){
            g.nodes.add(new Node(str));
        }
        for(String [] ds: dependencies){
            Node t = null;
            Node h = null;
            Edge e = null;
            for(Node n: g.nodes){
                if(n.name.equals(ds[0])){
                    t = n;
                }
                if(n.name.equals(ds[1])){
                    h = n;
                }
            }
            
            e = new Edge(h, t);
            g.edges.add(e);
            if(t != null){
                t.outgoingEdges.add(e);
            }
            if(h != null){
                h.incomingEdges.add(e);
            }
            
        }
        System.out.println(buildOrder(g));
        //End......
        ***************** */
        /*****Testing for Question 4.8
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
        ** */
        /**Testing for Question 4.9 *************
        TreeNode node = new TreeNode(100);
		int[] array = {90, 50, 20, 75, 150, 120, 170};
		for (int a : array) {
			node.insertInOrder(a);
		}

		ArrayList<LinkedList<Integer>> allSeq = allSequences(node);
        for (LinkedList<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());
        ************************************/
        /*****Testing for Question 4.10 ************
        // t2 is a subtree of t1
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {2, 3, 1};
		
		// TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
		// TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

		// if (checkSubtree(t1, t2)) {
		// 	System.out.println("t2 is a subtree of t1");
		// } else {
		// 	System.out.println("t2 is not a subtree of t1");
		// }

		// t4 is not a subtree of t3
		// int[] array3 = {1, 2, 1, 3, 1, 1};
        // int[] array3 = {1, 2, 1, 3, 1, 1, 5};
		// int[] array4 = {1,1,5};
		// TreeNode t3 = AssortedMethods.createTreeFromArray(array3);
		// TreeNode t4 = AssortedMethods.createTreeFromArray(array4);
        // t3.print();
        // t4.print();

		// if (checkSubtree(t3, t4)) {
		// 	System.out.println("t4 is a subtree of t3");
		// } else {
		// 	System.out.println("t4 is not a subtree of t3");
		// }
        ********************/

         /*****Testing for Question 4.12 ************/
      /*   TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
        // root.print();
		System.out.println(countPathsWithSum(root, 3)); */

        	
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
        root.print();
		System.out.println(countPathsWithSum(root, 8));

        // TreeNode root = new TreeNode(0);
		// root.left = new TreeNode(0);
		// root.right = new TreeNode(0);
		// root.right.left = new TreeNode(0);
		// root.right.left.right = new TreeNode(0);
		// root.right.right = new TreeNode(0);
		// System.out.println(countPathsWithSum(root, 0));
		// System.out.println(countPathsWithSum(root, 4));
    }

    // Question 4.12 Paths with Sum: You are given a binary tree in which each node contains an integer value (which
    // might be positive or negative). Design an algorithm to count the number of paths that sum to a
    // given value. The path does not need to start or end at the root or a leaf, but it must go downwards
    // (traveling only from parent nodes to child nodes).
    public static int countPathsWithSum(TreeNode root, int targetSum){
        return countSum(root, targetSum, 0, new Hashtable<Integer, Integer>());
    }
    private static int countSum(TreeNode root, int targetSum, int runnigSum, Hashtable<Integer, Integer> pathCounts){
        if(root == null) return 0;
        runnigSum += root.data;
        int sum = runnigSum - targetSum;
        int count = pathCounts.getOrDefault(sum, 0);
        if(runnigSum == targetSum){
            count++;
        }
        putIncreaseTable(runnigSum, pathCounts, 1);
        count += countSum(root.left, targetSum, runnigSum, pathCounts);
        count += countSum(root.right, targetSum, runnigSum, pathCounts);
        putIncreaseTable(runnigSum, pathCounts, -1);
        return count;
    }
    private static void putIncreaseTable(int runnigSum, Hashtable<Integer, Integer> pathCounts, int d){
        int newCount = pathCounts.getOrDefault(runnigSum, 0) + d;
        if(newCount == 0){
            pathCounts.remove(runnigSum);
        } else {
            pathCounts.put(runnigSum, newCount);
        }
    }


/*     public static int countPathsWithSum(TreeNode root, int targetSum){
        if(root == null) return 0;
        int mid = countPathsWithSumNode(root, targetSum, 0);
        int left = countPathsWithSum(root.left, targetSum);
        int right = countPathsWithSum(root.right, targetSum);
        return mid + left + right;
    } 
    public static int countPathsWithSumNode(TreeNode root, int targetSum, int sum){
        if(root == null) return 0;
        sum += root.data;
        int count = 0;
        if(sum == targetSum){
            count ++;
        }
        int left = countPathsWithSumNode(root.left, targetSum, sum);
        int right = countPathsWithSumNode(root.right, targetSum, sum);
        return left + right + count;
    } */
 /*    public static int countPathsWithSum(TreeNode root, int targetSum){
        int [] count = {0};
        travelCount(root, targetSum, count);
        return count[0];
    }
    private static void travelCount(TreeNode root, int targetSum, int [] count){
        if(root == null) return;
        int [] sum = {0};
        countSum(root, targetSum, count, sum);
        travelCount(root.left, targetSum, count);
        travelCount(root.right, targetSum, count);
    }
    private static void countSum(TreeNode root, int targetSum, int [] count, int [] sum){
        if(root == null) return;
        sum[0] += root.data;
        if(sum[0] == targetSum){
            count[0]++;
        }
        countSum(root.left, targetSum, count, sum);
        countSum(root.right, targetSum, count, sum);
        sum[0] -= root.data;
    } */

    // Question 4.10 Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
    // algorithm to determine if T2 is a subtree of Tl. A tree T2 is a subtree ofTi if there exists a node n in Ti such that the subtree of n is identical to T2.
    // That is, if you cut off the tree at node n, the two trees would be identical.
    // public static boolean checkSubtree(TreeNode t1, TreeNode t2){
    //     if(t2 == null) return true;
    //     return subtree(t1, t2);
    // }
    // private static boolean subtree(TreeNode t1, TreeNode t2){
    //     if(t1 == null) return false;
    //     if(t1.data == t2.data && preorderCheckSubtree(t1, t2))
    //         return true;
    //     return subtree(t1.left, t2) ||
    //             subtree(t1.right, t2);
    // }
    // private static boolean preorderCheckSubtree(TreeNode t1, TreeNode t2){
    //     if(t1 == null && t2 == null) return true;
    //     else if(t2 == null || t1 == null )
    //         return false;
    //     else if( t1.data != t2.data)
    //         return false;
    //     else
    //         return 
    //             preorderCheckSubtree(t1.left, t2.left) &&
    //             preorderCheckSubtree(t1.right, t2.right);
    // }

    // public static boolean checkSubtree(TreeNode t1, TreeNode t2){
    //     StringBuilder t1Str = new StringBuilder();
    //     StringBuilder t2Str = new StringBuilder();
    //     preorder(t1, t1Str);
    //     preorder(t2, t2Str);
    //     // if(t1Str.toString().contains(t2Str.toString())){
    //     //     return true;
    //     // } else {
    //     //     return false;
    //     // }
    //     return t1Str.indexOf(t2Str.toString()) != -1;
    // }
    // private static void preorder(TreeNode t, StringBuilder str){
    //     if(t == null){
    //         str.append("X");
    //         return;
    //     }
    //     str.append(" "+t.data);
    //     preorder(t.left, str);
    //     preorder(t.right, str);
    // }

    // Question 4.9 BST Sequences: A binary search tree was created by traversing through an array from left to right
    // and inserting each element. Given a binary search tree with distinct elements, print all possible
    // arrays that could have led to this tree.
    // public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node){
    //     ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
    //     if(node == null) {
    //         result.add(new LinkedList<Integer>());
    //         return result;
    //     }
    //     LinkedList<Integer> prefix = new LinkedList<Integer>();
    //     prefix.add(node.data);

    //     ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
    //     ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
        
    //     for(LinkedList<Integer> left: leftSeq){
    //         for (LinkedList<Integer> right: rightSeq){
    //             ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
    //             weaveLists(left, right, weaved, prefix);
    //             result.addAll(weaved);
    //         }
    //     }
    //     return result;
    // }
    // private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, 
    //         ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
    //     if(first.size() == 0 || second.size()==0){
    //         LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
    //         result.addAll(first);
    //         result.addAll(second);
    //         results.add(result);
    //         return;
    //     }
    //     int headFirst = first.removeFirst();
    //     prefix.addLast(headFirst);
    //     weaveLists(first, second, results, prefix);
    //     prefix.removeLast();
    //     first.addFirst(headFirst);

    //     int headSecond = second.removeFirst();
    //     prefix.addLast(headSecond);
    //     weaveLists(first, second, results, prefix);
    //     prefix.removeLast();
    //     second.addFirst(headSecond);

        
    // }

    // public static ArrayList<ArrayList<Integer>> BSTSequences(BSTNode bstNode){
    //     int r = bstNode.data;
    //     ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    //     ArrayList<Integer> arr = new ArrayList<Integer>();
    //     ArrayList<Integer> arrLeft = new ArrayList<Integer>();
    //     ArrayList<Integer> arrRight = new ArrayList<Integer>();
    //     travel(bstNode.left, arrLeft);
    //     travel(bstNode.right, arrRight);
    //     arr.add(r);
    //     weave(arrLeft, arrRight, arr, result);
    //     return result;
    // }
    // private static void weave(ArrayList<Integer> arrLeft, ArrayList<Integer> arrRight,ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result){
    //     if(arrLeft.size() == 0 || arrRight.size() == 0) return;
    //     for(Integer l: arrLeft){
    //         arr.add(l);
    //         for(Integer r: arrRight){
    //             arr.add(r);
    //             weave(arrLeft, arrRight, arr, result);
    //         }
    //     }
    //     result.add(arr);
    // }
    // private static void travel(BSTNode n, ArrayList<Integer> arr){
    //     if(n == null) return;
    //     travel(n.left, arr);
    //     arr.add(n.data);
    //     travel(n.right, arr);
    // }

//     // Question 4.8 First Common Ancestor: Design an algorithm and write code to find the first common ancestor
//     // of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
//     // necessarily a binary search tree.
//     public static BTNode lowestCommonAncestor(BTNode root, BTNode p, BTNode q) {
//         BTNode [] result = new BTNode[1];
//         lowestCommonAncestor(root, p, q, result);
//         return result[0];
//     }
//     public void lowestCommonAncestor(BTNode root, BTNode p, BTNode q, BTNode[] result) {
//         if(root == null) return;
//         if(root.data == p.data){
//             result[0] = p;
//             return;
//         } else if( root.data == q.data){
//             result[0] = q;
//             return;
//         }
//         TreeNode n = root;
//         boolean[] hasPQL = {false, false};
//         boolean[] hasPQR = {false, false};
//         travelDFS(n.left, p, q, hasPQL);
//         travelDFS(n.right, p, q, hasPQR);
//         if(hasPQL[0] && !hasPQL[1] && !hasPQR[0] && hasPQR[1]){
//             result[0] = root;
//             return;
//         }
//         else if(!hasPQL[0] && hasPQL[1] && hasPQR[0] && !hasPQR[1]){
//             result[0] = root;
//             return;
//         }
//         else if(hasPQL[0] && hasPQL[1]){
//             lowestCommonAncestor(root.left, p, q, result); 
//         }
//         else if(hasPQR[0] && hasPQR[1]){
//             lowestCommonAncestor(root.right, p, q, result);
//         }
//     }
//     public void travelDFS(TreeNode root, TreeNode p, TreeNode q, boolean[] hasPQ){
//         if(root == null) return;
//           if(root.data == p.data){
//             hasPQ[0] = true;
//         }
//         if(root.data == q.data){
//             hasPQ[1] = true;
//         }
//         travelDFS(root.left, p, q, hasPQ);
//         travelDFS(root.right, p, q, hasPQ);
      
//     }
// }

//     //Question 4.7 Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
//     // projects, where the second project is dependent on the first project). All of a project's dependencies
//     // must be built before the project is. Find a build order that will allow the projects to be built. If there
//     // is no valid build order, return an error.
//     public static LinkedList<Node> buildOrder(Graph g){
//         LinkedList<Node> result = new LinkedList<Node>();
//         LinkedList<Node> list = new LinkedList<Node>();
//         list.addAll(g.nodes);
//         boolean [] cycle = {false};
//         while(!list.isEmpty()){
//             Node n = list.remove();
//             if(n.state == Node.State.BLANK){
//                 travelDFS(n, result, cycle);
//             }
//         }
//         if(!cycle[0])
//         return result;
//         // else the Graph has cycle, then return null.
//         else return null;
//     }
//     private static void travelDFS(Node n, LinkedList<Node> result, boolean [] cycle){
//         if(n.state == Node.State.COMPLETE){
//             return;
//         }

//         if(!cycle[0]){
//             for(Edge e: n.outgoingEdges){
//                 if(e.head.state == Node.State.PARTIAL){
//                     //Mean the Graph has cycle.
//                         cycle[0] = true;
//                         return;
//                     }
//                 if(e.head.state == Node.State.BLANK){
//                     e.head.state = Node.State.PARTIAL;
//                     travelDFS(e.head, result, cycle);
//                 }
//             }
//         }
//         n.state = Node.State.COMPLETE;
//         result.addFirst(n);

//     }
    
       


//     // Question 4.6 Successor: Write an algorithm to find the "next" node (i .e., in-order successor) of a given node in a
//     // binary search tree. You may assume that each node has a link to its parent.
//     public static TreeNode inOrderSuccessorBST(TreeNode n) {
//         if(n == null) return null;
//         if(n.right != null) return findLeftNode(n.right);
        
//         else {
//                 TreeNode q = n;
//                 TreeNode x = q.parent;
//                 while(x != null && x.left != q){
//                     q = x;
//                     x = x.parent;
//                 }
//                 return x;
//             }
//     }
//     private static TreeNode findLeftNode(TreeNode n){
//         if(n == null) return null;
//         while(n.left != null) n = n.left;
//         return n;

//     }

//     // Question 4.5 Validate BST: Implement a function to check if a binary tree is a binary search tree.
//     // link: https://leetcode.com/problems/validate-binary-search-tree/
//     public static boolean isBinarySearchTree(BTNode node){
//         boolean [] test = new boolean[1];
//         test[0] = true;
//         checkBST(node, test);
//         return test[0];
//     }
//     private static int mid_val = Integer.MIN_VALUE;
//     private static void checkBST(BTNode node, boolean [] test){
//         if(node == null) return;

//         checkBST(node.left, test);
//         if(node.data <= mid_val){
//             test[0] = false;
            
//         } else{
//             mid_val = node.data;
//         }
//         checkBST(node.right, test);
//     }
//     //Solution From book.
//     // Integer last_printed = null;
//     // public boolean isValidBST(TreeNode n) {
//     //     if(n == null) return true;
//     //     if(!isValidBST(n.left)) return false;
//     //     if(last_printed != null && n.val <= last_printed) return false;
//     //     last_printed = n.val;
//     //     if(!isValidBST(n.right)) return false;
//     //     return true;
//     // }

//     //Question 4.4 Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
//     // this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
//     // node never differ by more than one.
//     public static boolean isBSTBalance(BSTNode bstNode){
//         boolean [] result = new boolean[1];
//         result[0] = true;
//         isBSTBalance(bstNode, result);
//         return result[0];
//     }
//     private static void isBSTBalance(BSTNode node, boolean [] result){
//         if(node == null) return;
//         int l = maxHeightBST(node.left);
//         int r = maxHeightBST(node.right);
//         if(Math.abs(l-r)>1){
//             result[0] = false;
//         }
//         isBSTBalance(node.left, result);
//         isBSTBalance(node.right, result);
//     }
//     private static int maxHeightBST(BSTNode n){
//         if(n == null) return 0;
//         int l = maxHeightBST(n.left);
//         int r = maxHeightBST(n.right);
//         if(l > r) return l + 1;
//         else return r + 1;
//     }
//     // Best solution from Book.
//     private static boolean isBalanced(BSTNode root){
//         return checkHeight(root) != Integer.MIN_VALUE; 
//     }
//     private static int checkHeight(BSTNode root){
//         if(root==null) return -1;

//         int leftHight = checkHeight(root.left);
//         if(leftHight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

//         int rightHight = checkHeight(root.right);
//         if(rightHight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

//         int height = Math.abs(leftHight - rightHight);
//         if(height > 1) return Integer.MIN_VALUE;
//         else return Math.max(leftHight, rightHight) +1;
//     }

//     // Question 4.3 List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
//     // at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
//     public static ArrayList<LinkedList<BSTNode>> listOfDepths(BSTNode n){
//         // ArrayList<LinkedList<BSTNode>> allb = new ArrayList<LinkedList<BSTNode>>();
//         // listOfDepths_DFS(n, allb, 0);
//         // return allb;
//         return listOfDepths_BFS(n);
//     }
//     private static void listOfDepths_DFS(BSTNode n, ArrayList<LinkedList<BSTNode>> allb, int level ){
//         if(n == null) return;
//         LinkedList<BSTNode> l = null;
//         if(allb.size()== level){
//             l = new LinkedList<BSTNode>(); 
//             allb.add(l);
//         } else {
//             l = allb.get(level);
//         }
//         l.add(n);
//         listOfDepths_DFS(n.left, allb, level+1);
//         listOfDepths_DFS(n.right, allb, level+1);
//     }
//     private static ArrayList<LinkedList<BSTNode>> listOfDepths_BFS(BSTNode bstNode){
//      ArrayList<LinkedList<BSTNode>> allb = new ArrayList<LinkedList<BSTNode>>();
//         LinkedList<BSTNode> current = new LinkedList<BSTNode>();
//         // visit the root or bstNode.
//         if(bstNode != null){
//             current.add(bstNode);
//         }
//         while(current.size() > 0) {
//             allb.add(current); // add previous level.
//             LinkedList<BSTNode> parents = current; // go to next level.
//             current = new LinkedList<BSTNode>();
//             for(BSTNode node: parents){
//                 // visit the children.
//                 if(node.left != null){
//                     current.add(node.left);
//                 }
//                 if(node.right != null){
//                     current.add(node.right);
//                 }
//             }
//         }
//         return allb;
//     }


  
//     // Question 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
//     // to create a binary search tree with minimal height.
//     // public static BSTNode createMinimalTree(int [] sortedArray){
//     //     int index = sortedArray.length / 2;
        
//     //     int data = sortedArray[index];
        
//     //     BSTNode  bstNode = new BSTNode(data, null, null);
//     //     int [] leftArray = Arrays.copyOfRange(sortedArray, 0, index);
//     //     int [] rightArray = Arrays.copyOfRange(sortedArray, index +1, sortedArray.length);
//     //     createMinimalTree(leftArray, rightArray, bstNode);
        
//     //     return bstNode;
//     // }
//     // private static void createMinimalTree(int [] leftArray, int [] rightArray,  BSTNode bstNode){
//     //     if(leftArray.length < 1 && rightArray.length < 1 ) return;
//     //     if(leftArray.length > 0){
//     //         createBSTNode(bstNode, leftArray[leftArray.length / 2]);
//     //         int [] newLeftArray = Arrays.copyOfRange(leftArray, 0, leftArray.length / 2);
//     //         int [] newRightArray = Arrays.copyOfRange(leftArray, leftArray.length / 2 + 1, leftArray.length);
//     //         createMinimalTree(newLeftArray, newRightArray, bstNode);
//     //     }
//     //     if(rightArray.length > 0){
//     //         createBSTNode(bstNode, rightArray[rightArray.length / 2]);
//     //         int [] newLeftArray1 = Arrays.copyOfRange(rightArray, 0, rightArray.length / 2);
//     //         int [] newRightArray1 = Arrays.copyOfRange(rightArray, rightArray.length / 2 + 1, rightArray.length);
//     //         createMinimalTree(newLeftArray1, newRightArray1, bstNode);
//     //     }
//     // }

//     public static void createBSTNode(BSTNode root, int data){
//         if( root == null){
//             return;
//         } 
//         if( data > root.data){
//             if( root.right == null){
//                 root.right = new BSTNode(data, null, null);
//             } else {
//                 createBSTNode(root.right, data);
//             }
//         } else {
//             if( root.left == null){
//                 root.left = new BSTNode(data, null, null);
//             } else {
//                 createBSTNode(root.left, data);
//             }
//         }
        
//     }

//     public static void printBSTNode(BSTNode root){
//         if(root == null) return;
//         printBSTNode(root.left);
//         System.out.print(" "+root.data);
//         printBSTNode(root.right);
//     }
    // private static void print_BFS(BSTNode root){
    //     Queue<BSTNode> q = new LinkedList<BSTNode>();
    //     root.visited = true;
    //     q.add(root); // add to the end of queue.
    //     while(!q.isEmpty()){
    //         BSTNode r = q.remove(); // Remove from the front of the queue.
    //         visit(r);
    //         if(r.left != null) {
    //             BSTNode l = r.left;
    //             if(l.visited == false){
    //                 l.visited  = true;
    //                 q.add(l);
    //             }
    //         }  
    //         if (r.right != null ){
    //                 BSTNode ri = r.right;
    //                 if (ri.visited == false){
    //                 ri.visited  = true;
    //                 q.add(ri);
    //             }
    //         }
    //     }
    // }
//     private static void visit(BSTNode n){
//         System.out.print(" "+n.data);
//     }
   
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
//  /***************************************************************** */
//     // Question 4.1 Route Between Nodes: Given a directed graph, design an algorithm 
//     // to find out whether there is a route between two nodes.
//     public static void isRouteBetweenNodes_DFS(Node n1, Node n2){
//         if(n1 == null ) return;
//         if(n1.name.equals(n2.name)) {
//             System.out.println("haha");
//         }
//         n1.visited = true;
//         for (Node n: n1.children){
//             if(n != null && n.visited == false){
//                 isRouteBetweenNodes_DFS(n, n2);
//             }
//         }
//         // return false;
//     }
//     public static boolean isRouteBetweenNodes_BFS(Node n1, Node n2){
//         Queue<Node> q = new LinkedList<Node>();
//         n1.visited = true;
//         q.add(n1); // add to the end of queue.
//         while(!q.isEmpty()){
//             Node r = q.remove(); // Remove from the front of the queue.
//             if(r.name.equals(n2.name)) return true;
//             for (Node n : r.children) {
//                 if(n != null && n.visited == false){
//                     n.visited = true;
//                     q.add(n);
//                 }
//             }
//         }
//         return false;
//     }
//     // Depth First Search
//     private static void search_DFS(Node root){
//         if(root == null) return;
//         visit(root);
//         root.visited = true;
//         for (Node n: root.children){
//             if(n.visited == false){
//                 search_DFS(n);
//             }
//         }
//     }
//     // Breadth First Search
//     private static void search_BFS(Node root){
//         Queue<Node> q = new LinkedList<Node>();
//         root.visited = true;
//         q.add(root); // add to the end of queue.
//         while(!q.isEmpty()){
//             Node r = q.remove(); // Remove from the front of the queue.
//             visit(r);
//             for (Node n : r.children) {
//                 if(n.visited == false){
//                     n.visited = true;
//                     q.add(n);
//                 }
//             }
//         }
//     }
//     private static void visit(Node n){
//         System.out.print(n);
//     }
}


// class BTNode{
//     public int data;
//     public BTNode left;
//     public BTNode right;
//     public BTNode(int data){
//         this.data = data;
//     }
//     public BTNode(int data, BTNode l, BTNode r){
//         this.data = data;
//         left = l;
//         right = r;
//     }
// }
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
    public BSTNode(int data){
        this.data = data;
    }
    public BSTNode(){}
    @Override
    public String toString(){
        return ""+ data;
    }
}

// class Node {
//     public String name;
//     public boolean visited;
//     public enum State {COMPLETE, PARTIAL, BLANK};
//     public State state;
//     public Node[] children;
//     public ArrayList<Edge> incomingEdges;
//     public ArrayList<Edge> outgoingEdges;
//     private int index;
//     public Node(String name){
//         this.name = name;
//         children = new Node[10];
//         incomingEdges = new ArrayList<Edge>();
//         outgoingEdges = new ArrayList<Edge>();
//         index = 0;
//         visited = false;
//         state = State.BLANK;
//     }
//     public void setChildren(Node n){
//         children[index] = n;
//         index++;
//     }
//     @Override
//     public String toString(){
//         return ""+ name;
//         // + " Incoming "+ incomingEdges+" outgoingEdges "+ outgoingEdges;
//     }
// }
// class Edge {
//     public Node head;
//     public Node tail;
//     public Edge(Node h, Node t){
//         head = h;
//         tail = t;
//     }
//     public Edge(){}
//     @Override
//     public String toString(){
//         return ""+tail+ " -> " + head;
//     }
// }
// class Graph {
//     public ArrayList<Node> nodes;
//     public ArrayList<Edge> edges;
//     public Graph(){
//         nodes = new ArrayList<Node>();
//         edges = new ArrayList<Edge>();
//     }
//     @Override
//     public String toString(){
//         return "nodes: "+nodes+ "\nedges " + edges;
//     }
// }

// // From Book
// //  Definition for a binary tree node.
// class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
//   }
 
