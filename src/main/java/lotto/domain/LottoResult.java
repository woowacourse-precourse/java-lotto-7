package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<String, Integer> result;
    private int prize;

    public LottoResult() {
        this.prize = 0;
        initResult();
    }

    private void initResult() {
        result = new HashMap<>();
        result.put("three", 0);
        result.put("four", 0);
        result.put("five", 0);
        result.put("fiveBonus", 0);
        result.put("six", 0);
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    public int getPrize() {
        return prize;
    }

    public void addResult(String rank) {
        result.replace(rank, result.get(rank) + 1);
    }

    public void updateResult() {
        this.prize = result.get("three") * 5000 +
                result.get("four") * 50000 +
                result.get("five") * 1500000 +
                result.get("fiveBonus") * 30000000 +
                result.get("six") * 2000000000;
    }
}
