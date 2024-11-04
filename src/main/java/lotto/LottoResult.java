package lotto;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.machine.PrizeStatus;

public class LottoResult {
    private Map<PrizeStatus, Integer> result = new LinkedHashMap<>();
    private int prizeValue = 0;

    public LottoResult() {
        PrizeStatus[] statuses = PrizeStatus.values();
        for (PrizeStatus status : statuses) {
            result.put(status, 0);
        }
    }

    public void incrementPrizeCount(PrizeStatus status) {
        result.put(status, result.getOrDefault(status, 0) + 1);
    }

    public void printResult(long purchaseValue) {
        System.out.println("당첨 통계");
        System.out.println();
        System.out.println("---");
        result.forEach((key, value) -> {
            String result = key.getStatusMessage() + " - " + value + "개";
            System.out.println(result);
            prizeValue += key.getPrizeMoney() * value;
        });

        double profitRatio = ((double)prizeValue / purchaseValue) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRatio);
    }
}
