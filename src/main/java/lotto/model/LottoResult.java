package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int FIRST_PRIZE_COUNT = 6;
    private static final int SECOND_PRIZE_COUNT = 5;
    private static final int THIRD_PRIZE_COUNT = 5;
    private static final int FOURTH_PRIZE_COUNT = 4;
    private static final int FIFTH_PRIZE_COUNT = 3;

    private static final long FIRST_PRIZE_AMOUNT = 2_000_000_000;
    private static final long SECOND_PRIZE_AMOUNT = 30_000_000;
    private static final long THIRD_PRIZE_AMOUNT = 1_500_000;
    private static final long FOURTH_PRIZE_AMOUNT = 50_000;
    private static final long FIFTH_PRIZE_AMOUNT = 5_000;

    private final Map<Integer, Integer> results;

    public LottoResult() {
        this.results = new HashMap<>();
        initializeResults();
    }

    private void initializeResults() {
        results.put(FIFTH_PRIZE_COUNT, 0);
        results.put(FOURTH_PRIZE_COUNT, 0);
        results.put(THIRD_PRIZE_COUNT, 0);
        results.put(SECOND_PRIZE_COUNT, 0);
        results.put(FIRST_PRIZE_COUNT, 0);
    }

    public void checkResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            int matchingCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            if (matchingCount == FIRST_PRIZE_COUNT) {
                results.put(FIRST_PRIZE_COUNT, results.get(FIRST_PRIZE_COUNT) + 1);
            } else if (matchingCount == SECOND_PRIZE_COUNT && lotto.getNumbers().contains(bonusNumber)) {
                results.put(SECOND_PRIZE_COUNT, results.get(SECOND_PRIZE_COUNT) + 1);
            } else if (matchingCount == THIRD_PRIZE_COUNT) {
                results.put(THIRD_PRIZE_COUNT, results.get(THIRD_PRIZE_COUNT) + 1);
            } else if (matchingCount == FOURTH_PRIZE_COUNT) {
                results.put(FOURTH_PRIZE_COUNT, results.get(FOURTH_PRIZE_COUNT) + 1);
            } else if (matchingCount == FIFTH_PRIZE_COUNT) {
                results.put(FIFTH_PRIZE_COUNT, results.get(FIFTH_PRIZE_COUNT) + 1);
            }
        }
    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void printResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("%d개 일치 (%,d원) - %d개\n", FIFTH_PRIZE_COUNT, FIFTH_PRIZE_AMOUNT, results.get(FIFTH_PRIZE_COUNT));
        System.out.printf("%d개 일치 (%,d원) - %d개\n", FOURTH_PRIZE_COUNT, FOURTH_PRIZE_AMOUNT, results.get(FOURTH_PRIZE_COUNT));
        System.out.printf("%d개 일치 (%,d원) - %d개\n", THIRD_PRIZE_COUNT, THIRD_PRIZE_AMOUNT, results.get(THIRD_PRIZE_COUNT));
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", SECOND_PRIZE_COUNT, SECOND_PRIZE_AMOUNT, results.get(SECOND_PRIZE_COUNT));
        System.out.printf("%d개 일치 (%,d원) - %d개\n", FIRST_PRIZE_COUNT, FIRST_PRIZE_AMOUNT, results.get(FIRST_PRIZE_COUNT));
    }

    public void calculateReturnOnInvestment(long totalInvestment) {
        long totalPrize = calculateTotalPrize();
        double returnOnInvestment = (double) totalPrize / totalInvestment * 100;

        returnOnInvestment = Math.round(returnOnInvestment * 10.0) / 10.0;

        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnOnInvestment);
    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        totalPrize += results.get(FIFTH_PRIZE_COUNT) * FIFTH_PRIZE_AMOUNT;
        totalPrize += results.get(FOURTH_PRIZE_COUNT) * FOURTH_PRIZE_AMOUNT;
        totalPrize += results.get(THIRD_PRIZE_COUNT) * THIRD_PRIZE_AMOUNT;
        totalPrize += results.get(SECOND_PRIZE_COUNT) * SECOND_PRIZE_AMOUNT;
        totalPrize += results.get(FIRST_PRIZE_COUNT) * FIRST_PRIZE_AMOUNT;
        return totalPrize;
    }
}
