package lotto.view;

import java.util.List;

public class OutputView {
    private final String NUMBER_OF_PURCHASE = "%d개를 구매했습니다.";
    private final String STATISTICS_HEADER = "\n당첨 통계\n---";
    private final String THREE_MATCHES = "3개 일치 (%,d원) - %d개";
    private final String FOUR_MATCHES = "4개 일치 (%,d원) - %d개";
    private final String FIVE_MATCHES = "5개 일치 (%,d원) - %d개";
    private final String FIVE_MATCHES_WITH_BONUS = "5개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private final String SIX_MATCHES = "6개 일치 (%,d원) - %d개";
    private final String TOTAL_PROFIT = "총 수익률은 %.1f%%입니다.";

    private final int THREE_MATCHES_PRIZE = 5000;
    private final int FOUR_MATCHES_PRIZE = 50000;
    private final int FIVE_MATCHES_PRIZE = 1500000;
    private final int FIVE_MATCHES_WITH_BONUS_PRIZE = 30000000;
    private final int SIX_MATCHES_PRIZE = 2000000000;

    public void printNumberOfPurchase(int purchase) {
        System.out.println(String.format(NUMBER_OF_PURCHASE, purchase));
    }

    public void printStatistics(List<Integer> matches, float profitRate) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(String.format(THREE_MATCHES, THREE_MATCHES_PRIZE, matches.get(0)));
        System.out.println(String.format(FOUR_MATCHES, FOUR_MATCHES_PRIZE, matches.get(1)));
        System.out.println(String.format(FIVE_MATCHES, FIVE_MATCHES_PRIZE, matches.get(2)));
        System.out.println(String.format(FIVE_MATCHES_WITH_BONUS, FIVE_MATCHES_WITH_BONUS_PRIZE, matches.get(3)));
        System.out.println(String.format(SIX_MATCHES, SIX_MATCHES_PRIZE, matches.get(4)));
        System.out.println(String.format(TOTAL_PROFIT, profitRate));
    }
}
