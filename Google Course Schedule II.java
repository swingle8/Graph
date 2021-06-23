class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int [] visited = new int [numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        for (int i = 0 ; i < prerequisites.length ; i++) {
            if (! map.containsKey(prerequisites[i][1]))
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        
        for (int i = 0 ; i < numCourses ; i++) {
            if (visited[i] == 0) {
                if (detectCycle(i, map, visited, ans)) {
                    return new int[0];
                }
            }
                
        }
        
        int [] ansInt = new int [numCourses];
        int j = ans.size() - 1;
        for (int i = 0 ; i < ans.size() ; i++) {
            ansInt[i] = ans.get(j);
            j--;
        }
        
        return ansInt;
    }
    
    
    public boolean detectCycle (int index, HashMap<Integer, ArrayList<Integer>> map, int [] visited, ArrayList<Integer> ans) {
        
        visited[index] = 1;
        ArrayList<Integer> children = map.get(index);
        
        for (int i = 0 ; children != null && i < children.size() ; i++) {
            int val = children.get(i);
            if (visited[val] == 1) {
                return true;
            }
            else if (visited[val] == 0) {
                if ( detectCycle (val, map, visited, ans))
                    return true;
            }
        }
        
        ans.add(index);
        visited[index] = 2;
        return false;
    }
}