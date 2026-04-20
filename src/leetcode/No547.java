package leetcode;

public class No547 {
    public int findCircleNum(int[][] isConnected) {
        int city_count = isConnected.length;
        int[] visited = new int[city_count]; // 记录访问过的节点
        int privince_count = 0;
        for(int i=0; i<city_count; i++){
            if(visited[i] == 0){ //  没有访问过 则访问与这个城市的所有节点

                dfs(isConnected, visited, i);

                privince_count++;
            }
        }
        return privince_count;
    }

    public void dfs(int[][] isConnected, int[] visited, int i){
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}