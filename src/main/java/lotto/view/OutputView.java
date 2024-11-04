package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.DrawNumbers;

public class OutputView {
    private static final String PURCHASE_NUMBER_OUTPUT = "개를 구매했습니다.";
    private static final String MATCH_RESULT = "당첨 통계\n---";
    private static final String MATCH_THREE_NUMBERS = "3개 일치 (5,000원) - %d개\n";
    private static final String MATCH_FOUR_NUMBERS = "4개 일치 (50,000원) - %d개\n";
    private static final String MATCH_FIVE_NUMBERS = "5개 일치 (1,500,000원) - %d개\n";
    private static final String MATCH_FIVE_AND_BONUS_NUMBERS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String MATCH_SIX_NUMBERS = "6개 일치 (2,000,000,000원) - %d개\n";

    private static final String PROFIT_PREFIX = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseLotto(List<DrawNumbers> drawSets) {
        int ticketCount = drawSets.size();

        System.out.println(ticketCount + PURCHASE_NUMBER_OUTPUT);

        for (DrawNumbers drawNumbers : drawSets) {
            System.out.println(drawNumbers.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printPrizeMoney(List<Integer> prizeMoneyGroup) {
        Map<Integer, Long> groupByPrize = prizeMoneyGroup.stream()
                .collect(Collectors.groupingBy(prize -> prize, Collectors.counting()));
        System.out.println(MATCH_RESULT);
        System.out.printf((MATCH_THREE_NUMBERS), findOrZero(groupByPrize, 5000));
        System.out.printf((MATCH_FOUR_NUMBERS), findOrZero(groupByPrize, 50000));
        System.out.printf((MATCH_FIVE_NUMBERS), findOrZero(groupByPrize, 1500000));
        System.out.printf((MATCH_FIVE_AND_BONUS_NUMBERS), findOrZero(groupByPrize, 30000000));
        System.out.printf((MATCH_SIX_NUMBERS), findOrZero(groupByPrize, 2000000000));
    }

    private static Long findOrZero(Map<Integer, Long> groupByPrize, int prize) {
        if (groupByPrize.get(prize) != null) {
            return groupByPrize.get(prize);
        }
        return 0L;
    }

    public static void printProfitRatio(Double profitRatio) {
        System.out.printf(PROFIT_PREFIX, profitRatio);
    }
}
