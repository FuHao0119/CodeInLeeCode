package leetcode;

import java.util.*;

public class No1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for(int stu:students){
            queue.offer(stu);
        }
        int sand_p = 0; int count = 0;
        while(true){
            if(queue.size() == 0 || sand_p == sandwiches.length){
                break;
            }
            if(count == queue.size()){
                break;
            }
            Integer head = queue.poll();
            if(head == sandwiches[sand_p]){
                sand_p++; count = 0;
            } else {
                queue.offer(head); count++;
            }
        }
        return queue.size();
    }
}
