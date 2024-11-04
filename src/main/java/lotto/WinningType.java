package lotto;

import java.util.HashMap;
import java.util.Map;

public enum WinningType {
    THREE, FOUR, FIVE, FIVE_BONUS, SIX;

    private static final Map<Integer, WinningType> countToMap = new HashMap<>();

    static {
        countToMap.put(3, THREE);
        countToMap.put(4, FOUR);
        countToMap.put(5, FIVE);
        countToMap.put(6, SIX);
        countToMap.put(7, FIVE_BONUS);
    }

    public static WinningType fromCount(int count) {
        return countToMap.get(count);
    }
}
