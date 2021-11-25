package chapters;

public class Chapter5_BitManipulation {
    public static void all() {
        // String binaryString = Integer.toString(insertion(0b10001111000,0b10011,2,6),2);
        // System.out.println(binaryString);
        double doubleValue = 0.72d;
String binaryString = Long.toBinaryString(Double.doubleToLongBits(doubleValue));
System.out.println(binaryString);
    }
    /**
     * 5.1 Insertion: You are given two 32-bit numbers, Nand M, and two bit positions, i
     * and j. Write a method to insert Minto N such that M starts at bit j and ends
     * at bit i. You can assume that the bits j through i have enough space to fit
     * all of M. That is, if M = 10011, you can assume that there are at least 5
     * bits between j and i. You would not, for example, have j = 3 and i = 2,
     * because M could not fully fit between bit 3 and bit 2.
     */
    public static int insertion(int N, int M, int i, int j){
        int allOnes = ~0;
        int left = allOnes << (j+1);
        int right = ((1<<i)-1);
        int mask = left | right;
        int n_cleared = N & mask;
        int m_shifted = M << i;
                return n_cleared | m_shifted;
    }
}
