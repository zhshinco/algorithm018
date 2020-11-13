public class NumOfIslands {

    public int numIslands(char[][] grid) {
        int ret = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    bfsReachAllLand(grid,i,j);
                    ret++;
                }
            }
        }

        return ret;
    }

    private void bfsReachAllLand(char[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1'){
            grid[i][j] = '0';
        }else{
            return;
        }

        bfsReachAllLand(grid,i,j+1);
        bfsReachAllLand(grid,i,j-1);
        bfsReachAllLand(grid,i+1,j);
        bfsReachAllLand(grid,i-1,j);
    }
}