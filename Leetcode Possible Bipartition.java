class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0 ; i < dislikes.length ; i++) {
            int p1 = dislikes[i][0];
            int p2 = dislikes[i][1];
            if (! map.containsKey(p1))
                map.put(p1, new ArrayList<Integer>());
            map.get(p1).add(p2);
            if (! map.containsKey(p2))
                map.put(p2, new ArrayList<Integer>());
            map.get(p2).add(p1);
        }
        
        int [] color = new int[n+1];
        for (int i = 0 ; i <= n ; i++)
            color[i] = -1;
        
        for (int i = 1 ; i < n ; i++) {
            if (color[i] == -1) {
                if (! partitionPossible(map, i, color))
                    return false;
            }
        }
       
        return true;
    }
    
    
    public boolean partitionPossible (HashMap<Integer, ArrayList<Integer>> map, int i, int [] color) {
        color[i] = 1;
        Stack<Integer> st = new Stack<Integer>();
        st.push(i);
        HashSet<Integer> parents = new HashSet<Integer>();
        
        while (! st.isEmpty()) {
            int len = st.size();
            for (int k = 0 ; k < len ; k++) {
                int parent = st.pop();
                parents.add(parent);
                
                ArrayList<Integer> children = map.get(parent);
                if (children == null)
                    continue;
                for (int child : children) {
                    if (parents.contains(child))
                        continue;
                    
                    if (color[child] == color[parent])
                        return false;
                    
                    color[child] = 1-color[parent];
                    st.push(child);
                }
                
            }
        }
        
        return true;
    }
        
}