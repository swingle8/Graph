// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    public int numIslands(char[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans =  0;
        boolean [][] visited = new boolean [rows][cols];
        for (int i = 0 ; i < rows ; i ++) {
            for (int j = 0 ; j < cols ; j++) {
                if (grid[i][j] == '1' && ! visited[i][j]) {
                    ans++;
                    connectIsland(i, j, grid, visited);
                }
                else if (grid[i][j] == '0')
                    visited[i][j] = true;
            }
        }
        return ans;
    }
    
    public void connectIsland (int i, int j, char [][] grid, boolean [][] visited) {
        visited[i][j] = true;
        
        if (j > 0 && ! visited[i][j-1] && grid[i][j-1] == '1') {
            connectIsland (i, j-1, grid, visited);
        }
        
        if (i > 0 && j > 0 && ! visited[i-1][j-1] && grid[i-1][j-1] == '1') {
            connectIsland (i-1, j-1, grid, visited);
        }
        
        if (i > 0 && ! visited[i-1][j] && grid[i-1][j] == '1') {
            connectIsland (i-1, j, grid, visited);
        }
        
        if (i > 0 && j < grid[0].length-1 && ! visited[i-1][j+1] && grid[i-1][j+1] == '1') {
            connectIsland (i-1, j+1, grid, visited);
        }
        
        if (j < grid[0].length-1 && ! visited[i][j+1] && grid[i][j+1] == '1') {
            connectIsland (i, j+1, grid, visited);
        }
        
        if (i < grid.length-1 && j < grid[0].length-1 && ! visited[i+1][j+1] && grid[i+1][j+1] == '1') {
            connectIsland (i+1, j+1, grid, visited);
        }
        
        if (i < grid.length-1 && ! visited[i+1][j] && grid[i+1][j] == '1') {
            connectIsland (i+1, j, grid, visited);
        }
        
        if (i < grid.length-1 && j > 0 && ! visited[i+1][j-1] && grid[i+1][j-1] == '1') {
            connectIsland (i+1, j-1, grid, visited);
        }
    }
}