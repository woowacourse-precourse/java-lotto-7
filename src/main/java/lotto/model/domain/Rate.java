package lotto.model.domain;

import java.util.HashMap;
import java.util.Map;

public class Rate {
    private Map<String,Integer> matchStatus = new HashMap<>();
    private int totalPrize = 0;
    private int totalAmount = 0;

    public Rate() {
        matchStatus.put("three_match",0);
        matchStatus.put("four_match",0);
        matchStatus.put("five_match",0);
        matchStatus.put("five_bonus_match",0);
        matchStatus.put("six_match",0);
    }

    public void updateMatchStatus(String matchCount) {
        matchStatus.put(matchCount,matchStatus.get(matchCount)+1);
    }
}
