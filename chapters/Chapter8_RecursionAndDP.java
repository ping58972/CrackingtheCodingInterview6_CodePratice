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

    int size = 5;
    boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);

    AssortedMethods.printMatrix(maze);

    ArrayList<Point> path = getPath(maze);
    if (path != null) {
      System.out.println(path.toString());
    } else {
      System.out.println("No path found.");
    }
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