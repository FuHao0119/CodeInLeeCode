package leetcode;

import java.util.HashSet;
import java.util.Set;

public class No1461 {
    public boolean hasAllCodes(String s, int k) {
        int all_prospect = (int)Math.pow(2,k);
        // System.out.println(all_prospect);
        Set<String> set = new HashSet<>();
        int i = 0; int j = i + k;
        while(j <= s.length()){
            String tmp_str = s.substring(i,j);
            // System.out.println(tmp_str);
            set.add(tmp_str);
            i++; j++;
        }
        int set_len = set.size();
        if(set_len == all_prospect) return true;
        return false;
    }
}
