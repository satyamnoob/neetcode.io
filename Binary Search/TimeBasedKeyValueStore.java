import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
    private int timestamp;
    private String value;

    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public String getValue() {
        return this.value;
    }
}

class TimeMap {
    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> pairs = map.get(key);
        String result = bsearch(pairs, timestamp);
        return result;
    }

    private String bsearch(List<Pair> pairs, int timestamp) {
        String result = "";
        int left = 0, right = pairs.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midTimestamp = pairs.get(mid).getTimestamp();

            if (midTimestamp <= timestamp) {
                result = pairs.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */