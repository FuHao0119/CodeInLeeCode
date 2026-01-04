package week_exam_483;

public class code1 {
    public String largestEven(String s) {
        for(int i = s.length()-1; i>=0; i--){
            if((int)s.charAt(i) % 2 != 0){
                s = s.substring(0,i);
            }else{
                return s;
            }
        }
        return "";
    }
}
