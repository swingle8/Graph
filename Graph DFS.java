// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            
            ArrayList<Integer> res = new Traversal().dfs(list, nov);
            for (int i = 0; i < res.size (); i++) 
                System.out.print (res.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
g : adjacency list of graph
N : number of vertices

return a list containing the DFS traversal of the given graph
*/

class Traversal
{
    static HashSet<Integer> hs;
    static StringBuffer sb;
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       hs = new HashSet<Integer>();
       sb = new StringBuffer();
       HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
       
       for (int i = 0 ; i < N ; i++ ) {
           int start = g.get(i).get(0);
           int end = g.get(i).get(1); 
           if (map.containsKey(start)) {
               ArrayList curr = map.get(start);
               curr.add(end);
               map.put(start, curr);
           }
           else {
               ArrayList<Integer> m = new ArrayList<Integer>();
               m.add(end);
               map.put(start, m);
           }
               
        }
        calculate(map, 0);
        System.out.println(sb);
    }
       
       
    static void calculate(HashMap<Integer, ArrayList<Integer>> map, int curr) {
        hs.add(curr);
        sb.append(curr);
        for (int neighbours : map.get(curr)) {
            if (! al.contains(curr))
                calculate (map, neighbours);
        }
    }
 }

