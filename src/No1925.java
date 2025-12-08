public class No1925 {
    public int countTriples(int n) {
        int count = 0;
        for(int i=n; i>0;i--){
            for(int a=1;a<n;a++){
                for(int b=1; b<n;b++){
                    if((a*a + b*b ) == i*i){
                        System.out.println(a + "方 + " + b + "方 = " + i + "方" );
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
