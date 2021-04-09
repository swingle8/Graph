// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

// adj : Adjacency list representing the graph
// V: No of vertices


class Solution
{
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //System.out.println(adj);
        boolean [] visitedOriginal = new boolean [V];
        boolean [] visitedModified = new boolean [V];
        Stack<Integer> st = new Stack<Integer>();
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0 ; i < V ; i++) {
            if (! visitedOriginal[i])
                traverseOriginal (adj, visitedOriginal, i, st);
        }
        reverse (adj, reverseAdj, V);
        int ans = 0;
        while (! st.isEmpty()) {
            int parent = st.pop();
            if (! visitedModified[parent]) {
                ans++;
                traverseModified (reverseAdj, visitedModified, parent);
            }
        }
        return ans;
    }
    
    public void traverseOriginal (ArrayList<ArrayList<Integer>> adj, boolean [] visitedOriginal, int node, Stack<Integer> st) {
        visitedOriginal[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (int child : children) {
            if (! visitedOriginal[child]) 
                traverseOriginal (adj, visitedOriginal, child, st);  
        }
        st.push(node);
    }
    
    public void traverseModified (ArrayList<ArrayList<Integer>> adj, boolean [] visitedModified, int node) {
        visitedModified[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (int child : children) {
            if (! visitedModified[child]) 
                traverseModified (adj, visitedModified, child);  
        }
    }
    
    public void reverse (ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> reverseAdj, int V) {
        for (int i = 0 ; i< V ; i++)
            reverseAdj.add(new ArrayList<Integer>());
        
        for (int i = 0 ; i < V ; i++) {
            ArrayList<Integer> children = adj.get(i);
            for (int child : children) {
                reverseAdj.get(child).add(i);
            }
        }
    }
}
