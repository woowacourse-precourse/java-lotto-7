package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Prize {
    private final Map<Integer, String> prizeMap = new HashMap<>();
    public Prize() {
        prizeMap.put(1, "2,000,000,000");
        prizeMap.put(2, "30,000,000");
        prizeMap.put(3, "1,500,000");
        prizeMap.put(4, "50,000");
        prizeMap.put(5, "5,000");
        prizeMap.put(6, "0");
    }

    public String getPrizeAmount(int rank){
        return this.prizeMap.get(rank);
    }
}
