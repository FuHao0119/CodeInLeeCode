package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No207 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[][] matrix = new int[numCourses][numCourses]; // 构造邻接矩阵
            for(int i=0; i<prerequisites.length; i++){
                int[] edge = prerequisites[i]; //一条边 edge[1] -> edge[0]
                matrix[edge[1]][edge[0]] = 1;
            }
            // 通过邻接矩阵检查图里有没有环 有环就返回false
            // 用一个数组保存所有节点的入度 找到入度为0的节点 将这个节点的出边都删掉（它指向的节点入度都-1)
            int[] ingrees = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                int count = 0; // 统计第i列的和
                for(int j=0; j<numCourses; j++){
                    count += matrix[j][i];
                }
                ingrees[i] = count;
            }
            /** 至此 已经将入度表创建好  */
            int[] visited = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>(); // 入度为0的节点的队列
            for(int i=0; i<numCourses; i++){
                if(ingrees[i] == 0) {
                    queue.offer(i);
                    visited[i] = 1;
                }
            }

            while(!queue.isEmpty()){
                Integer node_index = queue.poll(); // 第一个入度为0的节点出队
                for(int i=0; i<numCourses; i++){
                    if(matrix[node_index][i] == 1){
                        ingrees[i]--; //  对应入度-1
                    }
                }

                for(int i=0; i<numCourses; i++){
                    if(ingrees[i] == 0 && visited[i] == 0) {
                        queue.offer(i);
                        visited[i] = 1;
                    }
                }

            }

            // 最后在遍历visited表 如果全为1 说明没有环
            for(Integer vis:visited){
                if(vis == 0) return false;
            }
            return true;

        }
}
