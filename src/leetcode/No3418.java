package leetcode;

import java.util.PriorityQueue;

class No3418{
	    public int maximumAmount(int[][] coins) {
        int m = coins.length; int n = coins[0].length;
        int[][] diretions = {{1,0},{0,1}};
       
        int i=0; int j = 0; int sum = coins[0][0];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        if(coins[0][0] < 0) minHeap.offer(coins[0][0]);
        while(i != m-1 || j != n-1) {  // 只要还没到终点，就继续
            if(i == m-1) {
                int add_v = coins[i][j+1];
                sum += add_v; j++;
                System.out.println("add "+i + " ," + j + " value: " + add_v);
                if(add_v < 0){minHeap.offer(add_v);}
            }  else if(j == n-1) {
                int add_v = coins[i+1][j];
                sum += add_v; i++;
                 System.out.println("add "+i + " ," + j + " value: " + add_v);

                if(add_v< 0){minHeap.offer(add_v);}
            } else {
                int right_v = coins[i][j+1];
                int down_v = coins[i+1][j];
                
                if(right_v >= down_v) {
                    sum += right_v; j++;
                    System.out.println("add "+i + " ," + j + " value: " + right_v);
                    if(right_v < 0){minHeap.offer(right_v);}
                } 
                else {
                    sum += down_v;  i++;
                    System.out.println("add "+i+ ", " + j + " value: " + down_v);
                    if(down_v < 0){minHeap.offer(down_v);}
                }
            }
        }
        int count = 0;
        while (!minHeap.isEmpty()) {
            if(count==2) break;
            int poll = minHeap.poll();
            System.out.println("出队: " + poll);
            sum -= poll; count++;
        }
        return sum;
    }
}
