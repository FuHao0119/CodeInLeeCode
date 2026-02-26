package leetcode;

import java.util.*;

class No1404 {
    public int numSteps(String s) {
        LinkedList<Character> ll = new LinkedList<>();
        for(char c : s.toCharArray()){
            ll.add(c);
        }
        int step = 0;
        while(!(ll.size()==1 && ll.getLast()=='1')){
            if(ll.size()==1 && ll.getLast()=='0') return step+1;
            if(ll.getLast()=='0') ll.removeLast();
            else{
                int count_1 = 0;
                while(ll.size()!=0 && ll.getLast() != '0'){
                    ll.removeLast();
                    count_1++;
                }
                if(ll.size()==0){
                    ll.addFirst('1');
                }else{
                    ll.removeLast();
                    ll.addLast('1');
                }
                while(count_1 != 0){
                    ll.addLast('0');
                    count_1--;
                }
            }

            step++;
        }

        return step;
    }
}