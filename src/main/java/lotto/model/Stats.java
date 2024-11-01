package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Stats {
    Map<Integer, Integer> winningDetail = new HashMap<>();

    public void initStats(int rankCount) {
        for (int i = 1; i <= rankCount; i++) {
            winningDetail.put(i, 0);
        }
    }
}
