package chapters;

import java.util.*;
import java.lang.Math;

import CtCILibrary.*;

public class Chapter8_RecursionAndDP {
    public static void all(){
        //test for question 8.1
        for (int i = 0; i < 30; i++) {
			int c1 = countWays(i);
			int c2 = tripleStep(i);		
			System.out.println(i + ": " + c1 + " " + c2);
		}
    }

    /**
     * Question 8.1 riple Step: A child is running up a staircase 
     * with n steps and can hop either 1 step, 2 steps, or 3 steps 
     * at a time. Implement a method to count how many possible 
     * ways the child can run up the stairs.
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
    private static int tripleStep(int n, int [] memo){
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
}
