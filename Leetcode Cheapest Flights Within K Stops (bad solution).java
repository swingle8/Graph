class Solution {
    int ans = 100000000;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ans = 100000000;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int [][] cost = new int[n][n];
        for (int i = 0 ; i < flights.length ; i++) {
            int source = flights[i][0];
            int destination = flights[i][1];
            int price = flights[i][2];
           
            if (! map.containsKey(source))
                map.put(source, new ArrayList<Integer>());
            
            map.get(source).add(destination);
            cost[source][destination] = price;
        }
        
        int ans = dfs (map, cost, src, dst, k, 0);
        if (ans == 100000000)
            return -1;
        return ans;
    }
    
    public int dfs (HashMap<Integer, ArrayList<Integer>> map, int [][] cost, int src, int dst, int k, int currCost) {
        if (k == -1 && src != dst)
            return ans;
        if (src == dst)
            return currCost;
        if (ans < currCost)
            return ans;
        
        ArrayList<Integer> children = map.get(src);
        if (children == null)
            return ans;
        for (int child : children)
            ans = Math.min (ans, dfs (map, cost, child, dst, k-1, currCost + cost[src][child]));
        
        return ans;
    }
}