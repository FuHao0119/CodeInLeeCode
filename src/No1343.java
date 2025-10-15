public class No1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0; int j = k; int count = 0;
        double sum = 0;
        for(;i<k;i++){
            sum += arr[i];
        }
        double avg = sum / k;
        if(avg >= threshold) count++;
        i = 0;
        while(j<arr.length){
            sum -= arr[i++];
            sum += arr[j++];
            avg = sum / k;
            if(avg >= threshold) count++;
        }

        return count;
    }
}
