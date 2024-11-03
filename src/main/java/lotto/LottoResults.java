package lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class LottoResults {

    private final Map<Prize, Integer> prizeCount;
    private final int totalPrize;
    private final int moneySpent;

    public LottoResults(Map<Prize, Integer> prizeCount, int totalPrize, int moneySpent) {
        this.prizeCount = prizeCount;
        this.totalPrize = totalPrize;
        this.moneySpent = moneySpent;
    }

    public void printResults() {
        System.out.println("당첨 통계\n---");

        for (Prize prize : Prize.values()) {
            int count = prizeCount.getOrDefault(prize, 0);
            System.out.printf("%s (%s) - %d개%n",
                prize.getRankName(),
                formatCurrency(prize.getPrizeAmount()),
                count);
        }

        double profitRate = calculateProfitRate();
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private double calculateProfitRate() {
        if (moneySpent == 0) {
            return 0;
        }
        return ((double) totalPrize / moneySpent) * 100;
    }

    // 로또 번호를 형식에 맞게 출력
    public static String formatLottoNumbers(List<Integer> numbers) {
        return numbers.toString();
    }

    // 금액을 쉼표가 포함된 형식으로 출력
    public static String formatCurrency(int amount) {
        return NumberFormat.getInstance().format(amount) + "원";
    }
}
