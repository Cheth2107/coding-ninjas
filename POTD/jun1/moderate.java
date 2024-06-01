// You are given an array of ‘N’ non-negative integers where all elements appear an even number of 
// times except two, print the two odd occurring elements in increasing order. It may be assumed that the 
// size of the array is at-least two and there will always be exactly two numbers which appear an odd number of times in the given array.

//         EXAMPLE:
// Input: 'N' = 6, 'NUMS' = [1, 1, 2, 3, 4, 4]
// Output: 2 3

// Here in the given array we can see that 2 and 3 occur 1 time which is an odd number. Hence, the output will be 2 and 3.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
//         1 <= 'T' <= 10
//         2 <= 'N' <= 10^4
//         1 <= 'NUMS[i]' <= 10^5

// Time Limit: 1 sec
// Sample Input 1 :
//         2
//         6
//         1 1 2 3 4 4
//         2
//         1 2
// Sample Output 1 :
//         2 3
//         1 2
// Explanation Of Sample Input 1 :
// For the first test case,
//         'N' = 6 and 'NUMS' = [1, 1, 2, 3, 4, 4]
// Here in the given array we can see that 2 and 3 occur 1 time which is an odd  number. Hence, the output will be 2 and 3.

// For the second test case,
//         'N' = 2 and 'NUMS' = [1, 2]
// Here in the given array we can see that 1 and 2 occur 1 time which is an odd  number. Hence, the output will be 1 and 2.
// Sample Input 2 :
//         2
//         4
//         8 2 2 7
//         4
//         3 1 3 5
// Sample Output 2 :
//         7 8
//         1 5



// CODE:-


import java.util.*;

public class Solution {
    static int[] detectOdd(int n, int nums[]) {
        int xorResult = 0;

        // Step 1: XOR all elements to get x ^ y
        for (int num : nums) {
            xorResult ^= num;
        }

        // Step 2: Find a set bit in xorResult (rightmost set bit)
        int setBit = xorResult & ~(xorResult - 1);

        int x = 0, y = 0;

        // Step 3: Partition the array into two groups and XOR each group
        for (int num : nums) {
            if ((num & setBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // Step 4: Return the result in sorted order
        if (x < y) {
            return new int[] {x, y};
        } else {
            return new int[] {y, x};
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();  // Number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt();  // Size of the array
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int[] result = detectOdd(n, nums);
            System.out.println(result[0] + " " + result[1]);
        }

        scanner.close();
    }
}
