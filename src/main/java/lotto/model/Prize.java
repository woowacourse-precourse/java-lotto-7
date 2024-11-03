package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Prize {
    private final Map<Integer, Integer> prizeMap = new HashMap<>();
    public Prize() {
        prizeMap.put(1, 2000000000);
        prizeMap.put(2, 30000000);
        prizeMap.put(3, 1500000);
        prizeMap.put(4, 50000);
        prizeMap.put(5, 5000);
        prizeMap.put(6, 0);
    }

    public int getOfPrizeAmount(int rank){
        return this.prizeMap.get(rank);
    }
}
