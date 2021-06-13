class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>> (numCourses);
        
        for (int i = 0 ; i < numCourses ; i++)
            list.add(new ArrayList<Integer>());
        
        for (int i = 0 ; i < prerequisites.length ; i++) {
            int child = prerequisites[i][0];
            int parent = prerequisites[i][1];
            
            list.get(parent).add(child);
        }
        
        boolean ans = true;
        
        int [] color = new int[numCourses];
        for (int i = 0 ; i < numCourses && ans ; i++) {
            if (color[i] == 0)
            ans = dfs (list, i, color);
        }
        
        return ans;
    }
    
    public boolean dfs (ArrayList<ArrayList<Integer>> list, int i, int [] color) {
        color[i] = 1;
        boolean ans = true;
        
        ArrayList<Integer> children = list.get(i);
        for (int k : children) {
            if (color[k] == 2)
                continue;
            if (color[k] == 1 || ! ans)
                return false;
            ans = dfs (list, k, color);
        }
        
        color[i] = 2;
        return ans;
    }
}