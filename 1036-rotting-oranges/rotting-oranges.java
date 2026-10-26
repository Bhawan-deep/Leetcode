class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        int min=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue <int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                int[] el=q.remove();
                int x=el[0];
                int y=el[1];
                for(int arr[]:dir){
                    int newx=x+arr[0];
                    int newy=y+arr[1];
                    if(newx>=0 && newx<n && newy>=0 && newy<m && grid[newx][newy]==1){
                        fresh--;
                        q.add(new int[]{newx,newy});
                        grid[newx][newy]=2;
                    }
                }
                size--;
                
            }
            min++;
        }
        if(fresh>0){
            return -1;
        }
        if(min==0){
            return 0;
        }
            return min-1;
     
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna