/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
*/


class Solution {
  /* 
        L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
        L(i) = 1, if no such j exists.
    */
    public int lengthOfLIS(int[] nums) {
      
        int len = nums.length;
        int[] dp = new int[len];
        int result = 1;
        dp[0] = 1;
        for(int i = 1; i < len; i++) {
            int path = 0;
            for(int j = i - 1; j >=0; j--) {
                if(nums[i] > nums[j]){
                    path = Integer.max(dp[j] + 1, path);
                }
            }
            dp[i] = Integer.max(path, 1);
            result = Integer.max(result, path);
        }
        
        return result;
    }
}
