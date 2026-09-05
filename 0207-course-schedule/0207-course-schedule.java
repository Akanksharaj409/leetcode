class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indeg = new int[numCourses];

        for(int[] pre: prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
            indeg[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(indeg[i] == 0) {
                q.offer(i);
            }
        }

        int completed = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            completed++;

            for(int next: graph.get(course)) {
                indeg[next]--;

                if(indeg[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return completed == numCourses;
    }
}