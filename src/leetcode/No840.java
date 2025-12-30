package leetcode;

import java.util.HashSet;
import java.util.Set;

class No840 {
    public boolean noChongFu(int[][] grid, int x1, int y1){
        Set set = new HashSet<>();
        set.add(grid[x1][y1]);set.add(grid[x1][y1 + 1]);set.add(grid[x1][y1 + 2]);
        set.add(grid[x1 + 1][y1]);set.add(grid[x1+1][y1 + 1]);set.add(grid[x1+1][y1 + 2]);
        set.add(grid[x1+2][y1]);set.add(grid[x1+2][y1 + 1]);set.add(grid[x1+2][y1 + 2]);
        if(set.size() < 9) return false;
        return true;
    }
    public boolean outOfNine(int[][] grid, int x1, int y1){
        if(
                grid[x1][y1] > 9 || grid[x1][y1 + 1] > 9 || grid[x1][y1 + 2] > 9
                        || grid[x1 + 1][y1] > 9 || grid[x1 + 1][y1 + 1] > 9 || grid[x1 + 1][y1 + 2] > 9
                        || grid[x1 + 2][y1] > 9 || grid[x1 + 2][y1 + 1] > 9 || grid[x1 + 2][y1 + 2] > 9
                        || grid[x1][y1] <= 0 || grid[x1][y1 + 1] <= 0 || grid[x1][y1 + 2] <= 0
                        || grid[x1 + 1][y1] <= 0 || grid[x1 + 1][y1 + 1] <= 0 || grid[x1 + 1][y1 + 2] <= 0
                        || grid[x1 + 2][y1] <= 0 || grid[x1 + 2][y1 + 1] <= 0 || grid[x1 + 2][y1 + 2] <= 0
        ) return true;
        return false;
    }
    public boolean isHuanFang(int[][] grid, int x1, int y1) {
        if (!noChongFu(grid,x1,y1) || outOfNine(grid,x1,y1)) return false;
        Set set = new HashSet<>();
        set.add((grid[x1][y1] + grid[x1][y1 + 1] + grid[x1][y1 + 2]));
        set.add(grid[x1 + 1][y1] + grid[x1 + 1][y1 + 1] + grid[x1 + 1][y1 + 2]);
        set.add(grid[x1 + 2][y1] + grid[x1 + 2][y1 + 1] + grid[x1 + 2][y1 + 2]);
        set.add(grid[x1][y1] + grid[x1 + 1][y1] + grid[x1 + 2][y1]);
        set.add(grid[x1][y1 + 1] + grid[x1 + 1][y1 + 1] + grid[x1 + 2][y1 + 1]);
        set.add(grid[x1][y1 + 2] + grid[x1 + 1][y1 + 2] + grid[x1 + 2][y1 + 2]);
        set.add(grid[x1][y1] + grid[x1 + 1][y1 + 1] + grid[x1 + 2][y1 + 2]);
        set.add(grid[x1][y1 + 2] + grid[x1 + 1][y1 + 1] + grid[x1 + 2][y1]);
        if(set.size() > 1) return false;
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length < 3 || grid[0].length < 3) return 0;
        int count = 0;
        for(int x = 0; x < grid.length-2; x++){
            for(int y=0; y<grid[0].length-2; y++){
                if(isHuanFang(grid,x,y)) count++;
            }
        }
        return count;
    }
}