// You are given an array of ‘N’ non-negative integers where all elements appear an even number of times except 
// two, print the two odd occurring elements in increasing order. It may be assumed that the size of the array is 
// at-least two and there will always be exactly two numbers which appear an odd number of times in the given array.

// EXAMPLE:
// Input: 'N' = 6, 'NUMS' = [1, 1, 2, 3, 4, 4]
// Output: 2 3

// Here in the given array we can see that 2 and 3 occur 1 time which is an odd number. Hence, the output will be 2 and 3.

// Sample Input 1 :
// 2
// 6
// 1 1 2 3 4 4
// 2
// 1 2
// Sample Output 1 :
// 2 3
// 1 2
// Explanation Of Sample Input 1 :
// For the first test case,
// 'N' = 6 and 'NUMS' = [1, 1, 2, 3, 4, 4]
// Here in the given array we can see that 2 and 3 occur 1 time which is an odd  number. Hence, the output will be 2 and 3.

// For the second test case,
// 'N' = 2 and 'NUMS' = [1, 2]
// Here in the given array we can see that 1 and 2 occur 1 time which is an odd  number. Hence, the output will be 1 and 2.



 // CODE:-

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void setMatrixOnes(ArrayList<ArrayList<Integer>> MAT, int n, int m) {
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (MAT.get(i).get(j) == 1) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    MAT.get(i).set(j, 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        int t = sc.nextInt();

        // Process each test case
        for (int testCase = 0; testCase < t; testCase++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> MAT = new ArrayList<>();

            // Read matrix
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    row.add(sc.nextInt());
                }
                MAT.add(row);
            }

            // Apply the transformation
            setMatrixOnes(MAT, n, m);

            // Print the transformed matrix
            for (ArrayList<Integer> row : MAT) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
