package leetcode;

import java.util.PriorityQueue;

public class No703 {
}
class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for(int num:nums){
            this.pq.add(num);
            if(this.pq.size() > k){
                this.pq.poll();
            }
        }
    }

    public int add(int val) {
        this.pq.add(val);
        if(this.pq.size() > k){
            this.pq.poll();
        }
        return pq.peek();
    }
}
