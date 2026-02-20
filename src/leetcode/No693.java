package leetcode;

public class No693 {
    public boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        char a = str.charAt(0);
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == a) return false;
            a = str.charAt(i);
        }
        return true;
    }
}
