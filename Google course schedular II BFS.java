class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> que = new LinkedList<Integer>();
        HashMap<Integer, ArrayList<Integer>> map = new  HashMap<Integer, ArrayList<Integer>>();
        
        for (int i = 0 ; i < prerequisites.length ; i++) {
            if (! map.containsKey(prerequisites[i][1]))
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int [] inputtoVertices = new int[numCourses];
        for (int i : map.keySet()) {
            ArrayList<Integer> children = map.get(i);
            if (children == null)
                continue;
            
            for (int j = 0 ; j < children.size() ; j++) {
                inputtoVertices[children.get(j)]++;
            }
        }
        
        for (int i = 0 ; i < numCourses ; i++) {
            if (inputtoVertices[i] == 0) {
                que.add(i);
            }
        }
        
        int [] ans = new int[numCourses];
        int counter = 0;
        
        while (! que.isEmpty()) {
            int node = que.remove();
            ArrayList<Integer> children = map.get(node);
            for (int i = 0 ; children != null && i < children.size() ; i++) {
                inputtoVertices[children.get(i)]--;
                if (inputtoVertices[children.get(i)] == 0)
                    que.add(children.get(i));
            }
            ans[counter] = node;
            counter++;
        }
        
        if (counter != numCourses)
            return new int[0];
        return ans;
    }
}