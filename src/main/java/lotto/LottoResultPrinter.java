package lotto;

import java.util.Map;

public class LottoResultPrinter {

    private static final int[] PRIZES = {2000000000, 30000000, 1500000, 50000, 5000};

    public static void printResults(Map<String, Integer> resultCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int totalPrize = 0;
        totalPrize += printPrize("3개 일치 (5,000원)", resultCounts.get("5등"), PRIZES[4]);
        totalPrize += printPrize("4개 일치 (50,000원)", resultCounts.get("4등"), PRIZES[3]);
        totalPrize += printPrize("5개 일치 (1,500,000원)", resultCounts.get("3등"), PRIZES[2]);
        totalPrize += printPrize("5개 일치, 보너스 볼 일치 (30,000,000원)", resultCounts.get("2등"), PRIZES[1]);
        totalPrize += printPrize("6개 일치 (2,000,000,000원)", resultCounts.get("1등"), PRIZES[0]);

        printYield(totalPrize, calculateTotalAmountSpent(resultCounts));
    }

    private static int printPrize(String prizeDescription, int count, int prizeAmount) {
        System.out.printf("%s - %d개\n", prizeDescription, count);
        return count * prizeAmount;
    }

    private static void printYield(int totalPrize, int totalAmountSpent) {
        double yield = (double) totalPrize / totalAmountSpent * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    private static int calculateTotalAmountSpent(Map<String, Integer> resultCounts) {
        int totalTickets = 0;
        for (int count : resultCounts.values()) {
            totalTickets += count;
        }
        return totalTickets * 1000; // 로또 한 장당 1,000원
    }
}

