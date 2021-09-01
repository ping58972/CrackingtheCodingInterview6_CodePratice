/**
 * Solution on book and leetcode website: 
 * https://leetcode.com/discuss/general-discussion/1152824/cracking-the-coding-interview-6th-edition-in-leetcode
 */
package chapters;

import java.util.*;
import java.lang.Math;

import CtCILibrary.*;

public class Chapter8_RecursionAndDP {

  public static void all() {
    // test for question 8.1
    // for (int i = 0; i < 30; i++) {
    // int c1 = countWays(i);
    // int c2 = tripleStep(i);
    // System.out.println(i + ": " + c1 + " " + c2);
    // }
    // System.out.println(tripleStep(7));

    // int size = 5;
    // boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);

    // AssortedMethods.printMatrix(maze);

    // ArrayList<Point> path = getPath(maze);
    // if (path != null) {
    // System.out.println(path.toString());
    // } else {
    // System.out.println("No path found.");
    // }

    // 8.3
    // int[] arr = { -5, -3, 0, 2, 5, 5, 7, 7, 12, 13 };
    // int ans = magicIndex(arr);
    // System.out.println(ans);

    // // 8.4
    // Set<Character> set = new HashSet<>();
    // set.add('a');
    // set.add('b');
    // set.add('c');
    // set.add('d');
    // System.out.print("" + powerSet(set));

    // 8.5
    // int n = 10;
    // int m = 9;
    // int ans = recursiveMultiply(n, m);
    // System.out.println(ans == (n * m));

    // 8.6
    // Stack<Integer> s1 = new Stack<>();
    // Stack<Integer> s2 = new Stack<>();
    // Stack<Integer> s3 = new Stack<>();
    // s1.add(9);
    // s1.add(8);
    // s1.add(7);
    // s1.add(6);
    // s1.add(5);
    // s1.add(4);
    // s1.add(3);
    // s1.add(2);
    // s1.add(1);

    // System.out.println(s1);
    // hanoiTowers(s1, s2, s3);
    // System.out.println(s2);
    // System.out.println(s3);

    // 8.7
    // String str = "aabcc";
    // List<StringBuilder> l = permutationsWithoutDups(str);
    // System.out.println(l);
    // 8.8
    // String str = "aaacd";
    // Set<String> s = permutationsWithDups(str);
    // System.out.println(s);

    // 8.9
    // printAllParens(3);

    // 8.12 from book solution
    eightQueens(8);

  }

  /**
   * Eight Queens: Write an algorithm to print all ways of arranging eight queens
   * on an 8x8 chess board so that none of them share the same row, column, or
   * diagonal. In this case, "diagonal" means all diagonals, not just the two that
   * bisect the board.
   * 
   * @param n
   * @return
   */
  public static void eightQueens(int n) { // 3 < n < 9;
    ArrayList<Integer[]> results = new ArrayList<Integer[]>();
    Integer[] columns = new Integer[n];
    clear(columns, n);
    placeQueens(0, columns, results, n);
    printBoards(results, n);
    System.out.println(results.size());

  }

  //////
  // public static int n = 5;

  /*
   * Check if (row1, column1) is a valid spot for a queen by checking if there is
   * a queen in the same column or diagonal. We don't need to check it for queens
   * in the same row because the calling placeQueen only attempts to place one
   * queen at a time. We know this row is empty.
   */
  public static boolean checkValid(Integer[] columns, int row1, int column1) {
    for (int row2 = 0; row2 < row1; row2++) {
      int column2 = columns[row2];
      /* Check if (row2, column2) invalidates (row1, column1) as a queen spot. */

      /* Check if rows have a queen in the same column */
      if (column1 == column2) {
        return false;
      }

      /*
       * Check diagonals: if the distance between the columns equals the distance
       * between the rows, then they’re in the same diagonal.
       */
      int columnDistance = Math.abs(column2 - column1);
      int rowDistance = row1 - row2; // row1 > row2, so no need to use absolute value
      if (columnDistance == rowDistance) {
        return false;
      }
    }
    return true;
  }

  public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results, int n) {
    if (row == n) { // Found valid placement
      results.add(columns.clone());
    } else {
      for (int col = 0; col < n; col++) {
        if (checkValid(columns, row, col)) {
          columns[row] = col; // Place queen
          placeQueens(row + 1, columns, results, n);
        }
      }
    }
  }

  public static void clear(Integer[] columns, int n) {
    for (int i = 0; i < n; i++) {
      columns[i] = -1;
    }
  }

  public static void printBoard(Integer[] columns, int n) {
    drawLine(n);
    for (int i = 0; i < n; i++) {
      System.out.print("|");
      for (int j = 0; j < n; j++) {
        if (columns[i] == j) {
          System.out.print("Q|");
        } else {
          System.out.print(" |");
        }
      }
      System.out.print("\n");
      drawLine(n);
    }
    System.out.println("");
  }

  private static void drawLine(int n) {
    StringBuilder line = new StringBuilder();
    for (int i = 0; i < n * 2 + 1; i++)
      line.append('-');
    System.out.println(line.toString());
  }

  public static void printBoards(ArrayList<Integer[]> boards, int n) {
    for (int i = 0; i < boards.size(); i++) {
      Integer[] board = boards.get(i);
      printBoard(board, n);
    }
  }

  ///////

  /**
   * 8.11 Coins: Given an innnite number of quarters (25 cents), dimes (10 cents),
   * nickels (5 cents), and pennies (1 cent), write code to calculate the number
   * of ways of representing n cents.
   */
  public static int calculateCoinsRepresentingWays(int n) {
    return 0;
    // see book's solution and leetcode solution web
  }

  /**
   * 8.10 Paint Fill: Implement the "paint nil" function that one might see on
   * many image editing programs. That is, given a screen (represented by a
   * two-dimensional array of colors), a point, and a new color, nil in the
   * surrounding area until the color changes from the original color.
   */
  public static int[][] paintFill(int[][] image) {
    // see the solution 8.10.
    return null;
  }

  /**
   * 8.9 Parens: Implement an algorithm to print all valid (e.g., properly opened
   * and closed) combinations of n pairs of parentheses.
   * 
   * @param n int
   * @return void
   */
  public static void printAllParens(int n) {
    if (n == 0) {
      System.out.print("");
      return;
    }
    if (n == 1) {
      System.out.print("()");
      return;
    }
    Set<String> ans = allParens(n);
    System.out.print(ans);
  }

  private static Set<String> allParens(int n) {
    Set<String> set;
    if (n == 2) {
      set = new HashSet<>();
      set.add("()()");
      set.add("(())");
      return set;
    }
    set = allParens(n - 1);
    Set<String> s = new HashSet<>();
    for (String str : set) {
      StringBuilder strb = new StringBuilder(str);
      for (int i = 0; i < strb.length(); i++) {
        strb.insert(i, "()");
        s.add(strb.toString());
        strb = new StringBuilder(str);
      }
    }
    return s;
  }

  /**
   * 8.8 Permutations with Dups: Write a method to compute all permutations of a
   * string whose characters are not necessarily unique. The list of permutations
   * should not have duplicates.
   * 
   * @param str
   * @return set<String>
   */
  public static Set<String> permutationsWithDups(String str) {
    if (str == "" || str == null)
      return null;
    StringBuilder strb = new StringBuilder(str);
    Set<StringBuilder> setSB = permutationsWD(strb);
    Set<String> setS = new HashSet<>();
    for (StringBuilder sb : setSB) {
      setS.add(sb.toString());
    }
    return setS;
  }

  private static Set<StringBuilder> permutationsWD(StringBuilder strb) {
    Set<StringBuilder> set;
    if (strb.length() == 1) {
      set = new HashSet<>();
      set.add(strb);
    }
    if (strb.length() == 2) {
      set = new HashSet<>();
      StringBuilder sb1 = new StringBuilder(strb);
      set.add(sb1);
      StringBuilder sb2 = new StringBuilder();
      sb2.append(strb.charAt(1));
      sb2.append(strb.charAt(0));
      set.add(sb2);
      return set;
    }
    char c = strb.charAt(strb.length() - 1);
    strb.deleteCharAt(strb.length() - 1);
    set = permutationsWD(strb);
    Set<StringBuilder> ss = new HashSet<>();
    for (StringBuilder s : set) {
      StringBuilder sb = new StringBuilder(s);
      for (int j = 0; j <= s.length(); j++) {
        sb.insert(j, c);
        ss.add(sb);
        sb = new StringBuilder(s);
      }
    }
    return ss;

  }

  /**
   * 8.7 Permutations without Dups: Write a method to compute all permutations of
   * a string of unique characters.
   */
  public static List<StringBuilder> permutationsWithoutDups(String str) {
    if (str == "" || str == null)
      return null;
    StringBuilder strb = new StringBuilder(str);
    return permutations(strb);
  }

  private static List<StringBuilder> permutations(StringBuilder strb) {
    List<StringBuilder> list;
    if (strb.length() == 1) {
      list = new ArrayList<>();
      list.add(strb);
      return list;
    } else if (strb.length() == 2) {
      list = new ArrayList<>();
      StringBuilder sb1 = new StringBuilder(strb);
      list.add(sb1);
      StringBuilder sb2 = new StringBuilder();
      sb2.append(strb.charAt(1));
      sb2.append(strb.charAt(0));
      list.add(sb2);
      return list;
    }
    char c = strb.charAt(strb.length() - 1);
    strb.deleteCharAt(strb.length() - 1);
    list = permutations(strb);
    List<StringBuilder> l = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      StringBuilder sb = new StringBuilder(list.get(i));
      for (int j = 0; j <= list.get(i).length(); j++) {
        sb.insert(j, c);
        l.add(sb);
        sb = new StringBuilder(list.get(i));
      }
    }
    return l;
  }

  /**
   * Question 8.1 riple Step: A child is running up a staircase with n steps and
   * can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to
   * count how many possible ways the child can run up the stairs.
   */

  public static int countWays(int n) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else {
      return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }
  }

  public static int tripleStep(int n) {
    int[] map = new int[n + 1];
    Arrays.fill(map, -1);
    return tripleStep(n, map);
  }

  private static int tripleStep(int n, int[] memo) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else if (memo[n] > -1) {
      return memo[n];
    } else {
      memo[n] = tripleStep(n - 1, memo) + tripleStep(n - 2, memo) + tripleStep(n - 3, memo);
      return memo[n];
    }
  }

  /**
   * Question 8.2 Robot in a Grid: Imagine a robot sitting on the upper left
   * corner of grid with r rows and c columns. The robot can only move in two
   * directions, right and down, but certain cells are "off limits" such that the
   * robot cannot step on them. Design an algorithm to find a path for the robot
   * from the top left to the bottom right.
   */
  public static ArrayList<Point> getPath(boolean[][] maze) {
    if (maze == null || maze.length == 0)
      return null;
    ArrayList<Point> path = new ArrayList<Point>();
    HashSet<Point> failedPoints = new HashSet<Point>();
    if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
      return path;
    }
    return null;
  }

  public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path,
      HashSet<Point> failedPoints) {
    /* If out of bounds or not available, return. */
    if (col < 0 || row < 0 || !maze[row][col]) {
      return false;
    }

    Point p = new Point(row, col);

    /* If we've already visited this cell, return. */
    if (failedPoints.contains(p)) {
      return false;
    }

    boolean isAtOrigin = (row == 0) && (col == 0);

    /* If there's a path from the start to my current location, add my location. */
    if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints)
        || getPath(maze, row - 1, col, path, failedPoints)) {
      path.add(p);
      return true;
    }

    failedPoints.add(p); // Cache result
    return false;
  }

  /**
   * Question 8.3 Magic Index: A magic index in an array A [e ... n -1] is defined
   * to be an index such that A[ i] = i. Given a sorted array of distinct
   * integers, write a method to find a magic index, if one exists, in array A.
   */
  public static int magicIndex(int[] arr) {
    // return magicIndex(arr, 0, arr.length - 1);
    return magicFast(arr, 0, arr.length - 1);
  }

  private static int magicIndex(int[] arr, int start, int end) {
    if (end < start)
      return -1;
    int index = (start + end) / 2;
    if (arr[index] == index) {
      return index;
    } else if (index < arr[index]) {
      return magicIndex(arr, start, index - 1);
    } else if (index > arr[index]) {
      return magicIndex(arr, index + 1, end);
    }
    return -1;

  }

  public static int magicFast(int[] array, int start, int end) {
    if (end < start) {
      return -1;
    }
    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];
    if (midValue == midIndex) {
      return midIndex;
    }
    /* Search left */
    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = magicFast(array, start, leftIndex);
    if (left >= 0) {
      return left;
    }

    /* Search right */
    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = magicFast(array, rightIndex, end);

    return right;
  }

  /**
   * Question 8.4 Power Set: Write a method to return all subsets of a set.
   */
  public static Set<Set<Character>> powerSet(Set<Character> set) {
    Set<Set<Character>> totalSubset = new HashSet<Set<Character>>();
    powerSet(set, set.size(), totalSubset);
    return totalSubset;
  }

  private static void powerSet(Set<Character> set, int size, Set<Set<Character>> totalSubset) {
    if (size < 0)
      return;
    if (totalSubset.contains(set))
      return;
    else {
      totalSubset.add(set);
    }
    List<Character> list = new ArrayList<Character>(set);
    for (int i = 0; i < size; i++) {
      Set<Character> s = new HashSet<Character>(list);
      s.remove(list.get(i));
      powerSet(s, size - 1, totalSubset);
    }
  }

  /**
   * Question 8.5 Recursive Multiply: Write a recursive function to multiply two
   * positive integers without using the operator. You can use addition,
   * subtraction, and bit shifting, but you should minimize the number of those
   * operations.
   * 
   * @param m int
   * @param n int
   * @return m*n int
   */
  public static int recursiveMultiply(int m, int n) {
    int s = m < n ? m : n;
    int b = m > n ? m : n;
    return recursiveMultiply_helper(s, b);
  }

  private static int recursiveMultiply_helper(int s, int b) {
    if (s <= 1)
      return b;
    else if ((s & 1) != 0) {
      return recursiveMultiply_helper(s >> 1, b) + recursiveMultiply_helper(s >> 1, b) + b;
    } else
      return recursiveMultiply_helper(s >> 1, b) + recursiveMultiply_helper(s >> 1, b);
  }

  /**
   * Question 8.6 Towers of Hanoi: In the classic problem of the Towers of Hanoi,
   * you have 3 towers and N disks of different sizes which can slide onto any
   * tower. The puzzle starts with disks sorted in ascending order of size from
   * top to bottom (Le., each disk sits on top of an even larger one). You have
   * the following constraints: (1) Only one disk can be moved at a time. (2) A
   * disk is slid off the top of one tower onto another tower. (3) A disk cannot
   * be placed on top of a smaller disk. Write a program to move the disks from
   * the first tower to the last using stacks.
   */
  public static void hanoiTowers(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {

    int size = s1.size();
    hanoiTowers(size, s1, s2, s3);

  }

  private static void hanoiTowers(int size, Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
    if (size == 0)
      return;
    else if (size == 1) {
      Integer e = s1.pop();
      s3.add(e);
      return;
    } else if (size == 2) {
      Integer e1 = s1.pop();
      s2.add(e1);
      Integer e2 = s1.pop();
      s3.add(e2);
      e1 = s2.pop();
      s3.add(e1);
      return;
    }
    hanoiTowers(size - 1, s1, s3, s2);
    Integer e3 = s1.pop();
    s3.add(e3);
    hanoiTowers(size - 1, s2, s1, s3);
    return;
  }

}

class Point {
  public int row, column;

  public Point(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public String toString() {
    return "(" + row + ", " + column + ")";
  }

  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if ((o instanceof Point) && (((Point) o).row == this.row) && (((Point) o).column == this.column)) {
      return true;
    } else {
      return false;
    }
  }
}