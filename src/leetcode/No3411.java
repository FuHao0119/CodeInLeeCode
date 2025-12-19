package leetcode;

import java.util.*;

public class No3411 {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Map<Integer, Integer> userCountMap = new HashMap<>();
        Map<Integer, Integer> userOnOFFMap = new HashMap<>(); // 1表示在线
        for (int i = 0; i < numberOfUsers; i++) {
            userCountMap.put(i, 0);
            userOnOFFMap.put(i, 1);
        }

        Integer lastTime = 0;
        for(List<String> event : events) {
            if (event.get(0).contains("MESSAGE")) {
                Integer timestamp = Integer.parseInt(event.get(1));
                if(timestamp - lastTime >= 60){
                    for (Map.Entry<Integer, Integer> entry : userOnOFFMap.entrySet()) {
                        if(entry.getValue() == 0){
                            userOnOFFMap.put(entry.getKey(), 1);
                        }
                    }
                }
                if(event.get(2).contains("HERE")){  // 通知所有在线用户
                    for (Map.Entry<Integer, Integer> entry : userOnOFFMap.entrySet()) {
                        if(entry.getValue() == 1){
                            userCountMap.put(entry.getKey(), userCountMap.get(entry.getKey()) + 1);
                        }
                    }
                }else if(event.get(2).contains("ALL")){  // 通知所有用户
                    for (Map.Entry<Integer, Integer> entry : userCountMap.entrySet()) {
                        userCountMap.put(entry.getKey(), userCountMap.get(entry.getKey()) + 1);
                    }
                } else {  // 通知指定在线用户
                    String[] userIdList = event.get(2).split(" ");
                    for(String userId : userIdList) {
                        Integer id = Integer.parseInt(userId.split("id")[1]);
                        userCountMap.put(id, userCountMap.get(id)+1);
                    }
                }

            } else if (event.get(0).contains("OFFLINE")){
                Integer id = Integer.parseInt(event.get(2));
                Integer time = Integer.parseInt(event.get(1));
                userOnOFFMap.put(id,0);
                lastTime = time;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : userCountMap.entrySet()){
            list.add(entry.getValue());
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
