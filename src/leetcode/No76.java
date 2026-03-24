package leetcode;

import java.util.List;
import java.util.stream.Collectors;

public class No76 {
    public boolean func1(String subStr, String t){
        List<Character> charList = t.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for(int i = 0; i < subStr.length(); i++){
            if(charList.contains(subStr.charAt(i))){
                charList.remove(subStr.charAt(i));
            }
        }
        if(charList.size() == 0) return true;
        else return false;
    }

    public String minWindow(String s, String t) {
        List<Character> charList = t.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println(charList);

        charList.remove(0);
        System.out.println(charList);

        String ans = "";
        int i = 0;
        for(;i<s.length();i++){
            int j = i+t.length()-1;
            String sub = s.substring(i, j);
            if(func1(sub,t)) {
                ans = sub;
            }
            j++;
            while(j<s.length()){

                j++;
            }
        }


        return null;
    }

    public static void main(String[] args) {
        new No76().minWindow("","123132");
    }
}
