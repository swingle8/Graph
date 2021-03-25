// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    boolean ans = false;
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        ans = false;
        boolean [] visited = new boolean[adj.size()];
        for (int i = 0 ; i < adj.size() && !ans ; i++) {
            if (! visited[i]) {
                boolean [] visitedParent = new boolean[adj.size()];
                isCyclic (adj, i, visitedParent, visited);
            }
           
        }
        return ans;
    }
    
    public void isCyclic (ArrayList<ArrayList<Integer>> adj, int current, boolean [] visitedParent, boolean [] visited) {
        if (ans)
            return;
        visited [current] = true;
        ArrayList<Integer> children = adj.get(current);
        visitedParent[current] = true;
        for (int i = 0 ; i < children.size() && !ans ; i ++) {
            
            int data = children.get(i);
            if (visitedParent[data]) {
                ans = true;
                return;
            }
            isCyclic (adj, data, visitedParent, visited);
            
        }
        visitedParent[current] = false;
    }
}