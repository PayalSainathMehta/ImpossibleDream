import java.util.*;

public class CourseSchedule2 {
    //prerequisites is given as [a,b] -> b is a prereq for a.
    //so dest is prerequisites[i][0] and src is prerequisites[i][1]
    //and we create a map of src, list of dest i.e. prereq -> actual nodes.
    //now if indegree[actual node] == 0 that means this one doesnt have any prereqs,
    //we can then go and fetch its neighbors and check if they have prereqs or not.
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];  //final
        int[] indegree = new int[numCourses];  //store number of prereqs reqd
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = map.getOrDefault(src, new ArrayList());
            list.add(dest);
            map.put(src, list);
            //form how many prereqs you need for this course dest
            indegree[dest] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) //no prereqs required
                q.offer(i);

        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            result[i++] = node;
            if (map.containsKey(node)) {
                for (int neighbor : map.get(node)) {
                    indegree[neighbor]--; //since we just added its destination
                    if (indegree[neighbor] == 0) //add only if no prereqs
                        q.offer(neighbor);
                }
            }
        }
        if (i == numCourses) //we reached the end
            return result;
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] prereq = {{1,0},{2,0},{3,1},{3,2}};
        int n = 4;
        System.out.println(Arrays.toString(findOrder(n, prereq)));
    }
}
