/*
Given two strings. The task is to find the length of the longest common substring.


Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR"
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.
Example 2:

Input: S1 = "ABC", S2 "ACB"
Output: 1
Explanation: The longest common substrings
are "A", "B", "C" all having length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestCommonSubstr() 
which takes the string S1, string S2 and their length n and m as inputs and returns the length of the longest common substring in S1 and S2.


Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).
*/



class LargestCommonSubstring{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        // int longest(char[] c1, char[] c2, n, m) + c1[n-1] == c2[m-1] ? 1 : 0;
        //2d matrix dp[n][m]
        // if(i == 0) if(c1[i] == c2[j]) dp[i][j] = 1;
        //if(j == 0) if(c1[i) == c2[j]) dp[i][j] = 1;
        // dp[i][j] = (char[i] == char[j]) ? dp[i-1][j-1] + 1 : 0
        // longest(String s1, String s2, n-1, m-1) + c1
        
        char[] c1 = S1.toCharArray();
        char[] c2 = S2.toCharArray();
        
        int result = 0;
        
        int dp[][] = new int[n][m];
        
        for(int i = 0; i <= n-1 ; i++){
            for(int j =0; j <= m-1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = c1[i] == c2[j] ? 1 : 0;
                } else {
                    if(c1[i] == c2[j]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                result = Integer.max(result, dp[i][j]);
                
            }
        }
        
        return result;
        
       
    }
    
    
}
