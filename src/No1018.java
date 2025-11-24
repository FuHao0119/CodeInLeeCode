import java.math.BigInteger;
import java.util.*;

public class No1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < nums.length; i++){
            sum = sum.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(nums[i])) ;
            if(sum.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO)){
                result.add(true);
            }else {
                result.add(false);
            }
        }
        return result;
    }
}
