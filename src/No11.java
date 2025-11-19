public class No11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        int l = 0; int r = len-1;
        while(l < r){
            int area = (r-l) * Math.min(height[l],height[r]);
            maxArea = Math.max(area,maxArea);

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }


        return maxArea;
    }
}
