import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Chapter1_Array_String{
    //Qestion 1.1
    public static void isUnique(String str){
        int [] testArr = new int[1000];
        for(char ch: str.toCharArray()){
            int j = ch;
            testArr[j]++;
        }
        for(int i: testArr){
            if(i>1){
                System.out.println("It Is not Unique.");
                return;
            }
        } 
        System.out.println("It's Unique.");
        
    }
    public static boolean isUnique_solution(String str){
        if(str.length()>128) return false;
        boolean [] char_set = new boolean[128];
        for(int i =0; i<str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val])
            return false;
            char_set[val] = true;
        }
        return true;
    }
    // Question1.2 Check Permutation: Given two strings, 
    // write a method to decide if one is a permutation of the other.
    public static boolean checkPermutation_Ping(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        int sum1 =0;
        int sum2 = 0;
        for(int i=0; i<str1.length(); i++){
            int s1 = str1.charAt(i);
            int s2 = str2.charAt(i);
            sum1 += s1;
            sum2 += s2;
        }
        return (sum1 == sum2);
    }
    public static boolean checkPermutation(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        int counts[] = new int[128];
        for(int i=0; i<str1.length(); i++){
            int val = str1.charAt(i);
            counts[val]++;
        }
        for(int j=0; j<str2.length(); j++){
            int val = str2.charAt(j);
            counts[val]--;
            if(counts[val]<0) return false;
        }
        return true;
    }
    //Question 1.3 URLify: Write a method to replace all spaces in a string with '%20:
    // You may assume that the string has sufficient space at the end to hold 
    // the additional characters, and that you are given the "true" length of the string.
    public static String urLify(String str){
        String result = "";
        int end;
        for(end=str.length()-1; end>=0; end--){
            if((int)str.charAt(end) != 32) break;
        }
        for(int i=0; i<=end; i++){
            if((int)str.charAt(i) == 32){
                result += "%20";
            } else {
                result += str.charAt(i);
            }
        }
        return result+".";
    }

    //Question1.4 Palindrome Permutation: Given a string, write a function to check 
    // if it is a permutation of a palindrome. A palindrome is a word or phrase 
    // that is the same forwards and backwards. A permutation is a rea rrangement of letters.
    // The palindrome does not need to be limited to just dictionary words.
    public static boolean palindromePermutation(String str){
        int counts[] = new int[128];
        // System.out.println((char)((int)'C'+32));
        for(int i=0; i<str.length(); i++){
            if((int)'A'<= str.charAt(i) && (int)'Z' >= str.charAt(i)){
                counts[(int)str.charAt(i)+32]++;
            } else if (str.charAt(i) == ' '){
                continue;
            } else {
                counts[(int)str.charAt(i)]++;
            }
        }
        int test =0;
        for(int j=0; j<counts.length; j++){
            if(counts[j] ==0) continue;
            if(counts[j]%2 != 0){
                test++;
            }
        }
        
        return test < 2;
    }

    //Question1.5 One Away: There are three types of edits that can be performed on strings:
    //  insert a character, remove a character, or replace a character. Given two strings,
    // write a function to check if they are one edit (or zero edits) away.
    public static boolean oneAway(String str1, String str2) {
        int test = str1.length() - str2.length();
        int counts1[] = new int[128];
        int counts2[] = new int[128];
        if(test>1 || test < -1){
            return false;
        } else if ( test == 0){
            int cou=0;
            for(int i=0; i<str1.length(); i++){
                if(str1.charAt(i) != str2.charAt(i)){
                    cou++;
                }
            }
            if(cou >1) return false;
            return true;
        } else if(test == 1) {
            int j =0;
            int c =0;
            for(int i=0; i<str2.length(); i++){
                if(str2.charAt(j) != str1.charAt(i)){
                    c++;
                    j--;
                }
                j++;
            }
            if(c>1) return false;
            return true;
        } else if(test == -1){
              int j =0;
            int c =0;
            for(int i=0; i<str1.length(); i++){

                if(str1.charAt(j) != str2.charAt(i)){
                    c++;
                    j--;
                }
                j++;
            }
            if(c>1) return false;
            return true;
        } else return false;
    }

    // Question1.6 String Compression
    public static String stringCompression_Ping(String str){
        String result = "";
        int count = 1;
        char ch = 'a';
        for(int i=0; i<str.length()-1; i++){
            ch = str.charAt(i);
            if(str.charAt(i+1) == ch){
                count++;
            } else {
                result += ch +"" + count;
                count = 1;
            }

        }
        result += str.charAt(str.length()-1) +"" + count;
        return result;
    }
    public static String stringCompression(String str){
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for(int i=0; i<str.length(); i++){
            countConsecutive++;
            if(i+1>=str.length() || str.charAt(i+1) != str.charAt(i)){
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive =0;
            } 
        }
        return compressed.length()<str.length() ? compressed.toString() : str;
    }

    //Question1.7 Rotate Matrix: Given an image represented by an NxN matrix, 
    // where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. 
    // Can you do this in place?
    public static void rotateMatrix_Ping(int[][] matrix){
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                newMatrix[i][j] = matrix[matrix[0].length-1 -j][i];
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(newMatrix[i][j] +" ");
            }
            System.out.println();
        }
        
    }
    public static boolean rotateMatrix(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length != matrix.length) return false;
        int n = matrix.length;
        for(int layer=0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i=first; i<last; i++){
                int offset = i - first;
                int top = matrix[first][i]; //save top
                // left -> top
                matrix[first][i] = matrix[last-offset][first];
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top; //right <- saved top
            }
        }
        return true;
    }

    // Question1.8 Zero Matrix: Write an algorithm such that if an element 
    // in an MxN matrix is 0, its entire row and column are set to O. 
    public static boolean zeroMatrix(int [][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> nSet = new HashSet<>(n);
        Set<Integer>  mSet = new HashSet<>(m);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==0){
                    nSet.add(i);
                    mSet.add(j);
                }
            }
        }
        for(Integer x: nSet ){
            matrix[x] = new int[m];
        }
        for(Integer y: mSet){
            for(int j=0; j<n; j++){
                matrix[j][y] = 0;
            }
        }
        return true;
    }
    
    // Question 1.9 String Rotation: Assume you have a method isSubst ring which checks 
    // if one word is a substring of another. Given two strings, 51 and 52, write code 
    // to check if 52 is a rotation of 51 using only one call to isSubstring (e.g., 
    // "waterbottle" is a rotation of"erbottlewat").
    public static boolean isSubstringRotation(String str1, String str2){
        if(str1.length()!= str2.length()) return false;
        StringBuilder concat = new StringBuilder(str2);
        concat.append(str2);
        if(concat.indexOf(str1) != -1) return true;
        return false;
    }
}