package lotto.service;

import java.util.HashMap;
import java.util.Map;
import lotto.global.enums.Prize;

public class ResultService {
    private Map<Prize, Integer> prizeCountMap = new HashMap<>();

    public ResultService() {
        for(Prize prize : Prize.values()) {
            prizeCountMap.put(prize, 0);
        }
    }

    public void updatePrizeCount(int matchCount, boolean containsBonus) {
        for (Prize prize : Prize.values()) {
            if(prize.getMatchCount() == matchCount && prize.requiresBonus() == containsBonus){
                prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
                break;
            }
        }
    }
}
