class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        List<List<Integer>> graph=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new LinkedList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            graph.get(u).add(v);
        }
        
        boolean vis[]=new boolean[numCourses];
        boolean path[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(detect(graph,i,vis,path)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean detect(List<List<Integer>> graph,int curr,boolean vis[],boolean path[]){
        vis[curr]=true;
        path[curr]=true;
        for(int next:graph.get(curr)){
            if(!vis[next]){
                if(detect(graph,next,vis,path)){
                    return true;
                }
            }else if(path[next]){
                return true;
            }
        }
        path[curr]=false;
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna