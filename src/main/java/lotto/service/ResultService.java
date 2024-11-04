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

    public void rateOfReturn(int money) {
        int totalPrizeAmount = 0;

        for (Prize prize : Prize.values()) {
            int count = prizeCountMap.get(prize);
            totalPrizeAmount += prize.getAmount() * count;
        }

        double percent = (double) totalPrizeAmount / money * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.", percent);
    }
}
