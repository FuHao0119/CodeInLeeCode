public class No2536 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] maze = new int[n][n];


        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            for(int a = x1; a <= x2; a++){
                for(int b = y1; b <= y2; b++){
                    maze[a][b]++;
                }
            }
        }

        return maze;

    }
}
