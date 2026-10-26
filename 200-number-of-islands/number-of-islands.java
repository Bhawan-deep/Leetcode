class Solution {
    int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
    class Pair{
        int i;
        int j;
        Pair(int x,int y){
            i=x;
            j=y;
        }
    }
    public int numIslands(char[][] grid) {
        int islands=0;
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    bfs(grid,vis,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public boolean isSafe(int x,int y,char[][] grid){
        return (x>=0 && y>=0 && x<grid.length && y<grid[0].length);
    }
    
    public void bfs(char[][] grid,boolean vis[][],int i,int j){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int currx=curr.i;
            int curry=curr.j;
            for(int d[]:dir){
                int newx=currx+d[0];
                int newy=curry+d[1];
                if(isSafe(newx,newy,grid) && !vis[newx][newy] && grid[newx][newy]=='1'){
                    vis[newx][newy]=true;
                    q.add(new Pair(newx,newy));
                }
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna