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
    int n = 10;
    int m = 9;
    int ans = recursiveMultiply(n, m);
    System.out.println(ans == (n * m));

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
   * Magic Index: A magic index in an array A [e ... n -1] is defined to be an
   * index such that A[ i] = i. Given a sorted array of distinct integers, write a
   * method to find a magic index, if one exists, in array A.
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
   * Power Set: Write a method to return all subsets of a set.
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
   * Recursive Multiply: Write a recursive function to multiply two positive
   * integers without using the operator. You can use addition, subtraction, and
   * bit shifting, but you should minimize the number of those operations.
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