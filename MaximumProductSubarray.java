/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        
        int max = nums[0];
        int min = nums[0];
        
        int result = Integer.max(max, min);
        for(int i = 1; i < nums.length; i++) {
            
            if(nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            
            max = Integer.max(nums[i], max * nums[i]);  
            min = Integer.min(nums[i], min * nums[i]);  
            result = Integer.max(max, result); 
        }
        
        
        return result;
    }
}
