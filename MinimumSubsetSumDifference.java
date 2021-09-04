/*
Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference


Example 1:

Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11   
Example 2:
Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4

Your Task:  
You don't need to read input or print anything. Complete the function minDifference() which takes N and array arr as input parameters and returns the integer value


Expected Time Complexity: O(N*|sum of array elements|)
Expected Auxiliary Space: O(N*|sum of array elements|)
*/


class Solution
{
    
   // // int minDiff(arr[], n)
    

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    for(int i = 0; i < n; i++) {
	        sum = sum + arr[i];
	    }
	    
	    //diff = s2 - s1 = (sum - s1) - s1 = sum - 2*s1;
	    //s1 <= s2 = s1 <= sum/2
	    
	    boolean dp[][] = new boolean[sum + 1][n+1];
	    
	    for(int i = 0; i <= n; i++ ){
	        dp[0][i] = true;
	    }
	    
	    for(int j = 1; j <= sum;j++){
	        dp[j][0] = false;
	    }
	    
	    for(int i = 1; i <= sum;i++){
	        for(int j = 1; j <= n; j++) {
	            if(arr[j-1] <= i){
	                dp[i][j] = dp[i - arr[j-1]][j-1] || dp[i][j-1];
	            } else {
	                dp[i][j] = dp[i][j-1];
	            }
	        }
	    }
	    
	    int diff = Integer.MAX_VALUE;
	    
	    for(int i = sum/2; i>=0 ; i--) {
	        if(dp[i][n]){
	            diff = Integer.min(diff, sum - 2 * i);
	        }
	    }
	    return diff;
	    
	} 
}
