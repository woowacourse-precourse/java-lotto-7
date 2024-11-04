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

    public void printLottoResult() {
        for (Prize prize : Prize.values()) {
            int count = prizeCountMap.get(prize);
            System.out.printf("%d개 일치", prize.getMatchCount());
            if(prize.requiresBonus()) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf(" (%s원) - %d개\n", String.format("%,d", prize.getAmount()), count);
        }
    }
}
