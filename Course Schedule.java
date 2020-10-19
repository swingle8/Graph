//https://leetcode.com/problems/course-schedule/
class Solution {
    
    boolean [] completed;
    boolean doable = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int rows = prerequisites.length;
        
        for (int i = 0 ; i < rows ; i ++) {
            int key = prerequisites[i][0];
            int val = prerequisites[i][1];
            
            if (map.containsKey(key)) {
                ArrayList listVal = map.get(key);
                listVal.add(val);
                map.put(key, listVal);
            }
            else {
                ArrayList listVal = new ArrayList<Integer>();
                listVal.add(val);
                map.put(key, listVal);
            }
        }
        
        completed = new boolean[numCourses];
        doable = true;
        for (int i = 0 ; i < numCourses ; i++) {
            if (! completed[i])
                dfs(map, i, new boolean[numCourses]);
        }
        return doable;
    }
    
    public void dfs (HashMap<Integer, ArrayList<Integer>> map, int num, boolean [] visited) {
        if (visited[num]) {
            doable = false;
            return;
        }
        
        visited[num] = true;
        ArrayList<Integer> parent = map.get(num);
        for (int i = 0 ; parent != null && i < parent.size() ; i++) {
            int nextNum = parent.get(i);
            if (! completed[nextNum])
                dfs (map, nextNum, visited);
        }
        completed[num] = true;
    }
}