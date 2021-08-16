/*
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
*/


class Solution {
     /*
             1. int longestPalindrome(arr, start, end)
             2. Recursion expression: 
                    if( arr[start] == arr[end]) 
                            return 2 + longestPalindrome(arr, start + 1, end - 1);
                    else
                            return max(longestPalindrome(arr, start, end - 1), longestPalindrome(arr, start + 1, end);
             3. Base case: if( start == end) {
                        return 1;
                    }
             4. 2D array
             6. if( i == j ) dp[i][j] = 1;
             5. dp[i][j] = if(arr[i] == arr[j]) ? 2 + dp[i+1, j-1] : max(dp[i][j-1], dp[i+1][j])
        */
        
        
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
       
        int[][] dp = new int[len][len];
        
        for(int i =0;i < len; i++) {
            dp[i][i] = 1;
        }
        int result = 1;
        for(int ch = 2; ch <= len; ch++){
            for(int i =0; i < len-ch+1 ;i++){
                int  j = i + ch - 1;
                if(arr[i] == arr[j] && ch == 2) {
                    dp[i][j] = 2;
                } else if(arr[i] != arr[j]) {
                    dp[i][j] = Integer.max(dp[i][j-1], dp[i+1][j]);
                } else if(arr[i] == arr[j]) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                result = Integer.max(result, dp[i][j]);
            }
        }
        return result;
        
    }
}
