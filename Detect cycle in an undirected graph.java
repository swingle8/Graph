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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution
{
    boolean ans = false;
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //System.out.println(adj);
        ans = false;
        boolean [] visited = new boolean[V];
        for (int i = 0; i < adj.size() ; i ++) {
            int parent = -1;
            int current = i;
            if (! visited[i])
                hasLoop(adj, parent, visited, current);
        }
        
        return ans;
    }
    
    public void hasLoop (ArrayList<ArrayList<Integer>> adj, int parent, boolean [] visited, int current) {
        if (adj.size() == current)
            return;
        
        visited[current] = true;
        //parent = current;
        ArrayList<Integer> children = adj.get(current);
        for (int i = 0 ; i < children.size() ; i++) {
            int next = children.get(i);
            if (! visited[next]) 
                hasLoop (adj, current, visited, next);
            
            else if (parent != next) {
                ans = true;
                return;
            }
            
        }
    }
}