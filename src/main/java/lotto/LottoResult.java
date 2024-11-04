package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> resultMap = new HashMap<>();

    public void addResult(Rank rank) {
        resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : resultMap.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize;
    }
}
