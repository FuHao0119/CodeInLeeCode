package leetcode;

import java.util.*;

public class Router {
    private int usedMemory;
    private final int memoryLimit;
    private final Queue<int[]> queue;

    // 用于快速重复检查
    private final Set<String> packetSet;

    // 用于快速计数查询：destination -> 按时间排序的包列表
    private final Map<Integer, List<Integer>> destinationTimestamps;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.usedMemory = 0;
        this.queue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destinationTimestamps = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + ":" + destination + ":" + timestamp;

        // 重复检查：O(1)
        if (packetSet.contains(key)) {
            return false;
        }

        // 内存已满时转发一个包
        if (usedMemory >= memoryLimit) {
            forwardPacket();
        }

        // 添加数据包
        int[] packet = {source, destination, timestamp};
        queue.offer(packet);
        usedMemory++;
        packetSet.add(key);

        // 更新计数索引
        destinationTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (usedMemory == 0) {
            return new int[]{};
        }

        int[] packet = queue.poll();
        usedMemory--;

        // 清理相关数据
        String key = packet[0] + ":" + packet[1] + ":" + packet[2];
        packetSet.remove(key);

        // 从计数索引中移除
        int destination = packet[1];
        int timestamp = packet[2];
        List<Integer> timestamps = destinationTimestamps.get(destination);
        if (timestamps != null) {
            timestamps.remove((Integer) timestamp);
            if (timestamps.isEmpty()) {
                destinationTimestamps.remove(destination);
            }
        }

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> timestamps = destinationTimestamps.get(destination);
        if (timestamps == null) {
            return 0;
        }

        // 使用二分查找优化计数
        int count = 0;
        for (int ts : timestamps) {
            if (ts >= startTime && ts <= endTime) {
                count++;
            }
        }
        return count;
    }
}