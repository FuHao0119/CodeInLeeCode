package leetcode;

public class No3047 {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxLen = 0;
        int n = bottomLeft.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 计算两个矩形的交集
                int leftX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int rightX = Math.min(topRight[i][0], topRight[j][0]);
                int bottomY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int topY = Math.min(topRight[i][1], topRight[j][1]);

                // 如果有交集
                if (leftX < rightX && bottomY < topY) {
                    int width = rightX - leftX;
                    int height = topY - bottomY;
                    int side = Math.min(width, height);
                    maxLen = Math.max(maxLen, side);
                }
            }
        }

        return maxLen * maxLen;
    }
}