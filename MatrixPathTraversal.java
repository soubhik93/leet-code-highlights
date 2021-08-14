/*
 given a m*n grid, filled with non-negative integers.
   find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
   You can only move either down or right at any point in time.

  [1 3 1]
  [2 3 2]
  [4 3 1] 

  o/p : [8] => 1->3->1->2->1

  [1 3 1]
  [1 5 1]
  [4 2 1]
  
 [1 4 5]
 [2 7 6]
 [6 8 7]
 
 
 1 -> 1 -> 4->2 -> 1
 1 -> 3 -> 1 -> 1 ->1
  o/p = 7
*/

//  int findMinSum(grid[][], int m, int n)
  //    min(findMinSum(grid, m, n -1),  findMinSum(grid, m, n -1)) + grid[m][n];
  //    if(m == 0 && N == 0) grid[0][0]
  
  //   dp[i][j] = min(dp[i][j-1], dip[i-1][j]) + grid[i][j]
  
  
  public int findMinSum(grid[][], int m, int n) {
  	int[][] dp = new int[m][n];
    
    dp[0][0] = grid[0][0];
    for(int i = 1; i<m ; i++) {
    	dp[i][0] = dp[i-1][0] + grid[i][0];
    }
    
    for(int j = 1; j<n ; j++) {
    	dp[0][j] = dp[0][j-1] + grid[0][j];
    }
    
    for(int i =1; i < m; i++) {
    	for(int j = 1; j < n ; j++) {
      	dp[i][j] = min(dp[i][j-1], dip[i-1][j]) + grid[i][j]
      }
    }
    
    return dp[m][n];

  }
