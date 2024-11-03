package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import lotto.entity.Lottos;
import lotto.enums.NotificationMessage;
import lotto.enums.Prize;

import java.util.List;

public class OutputView {

    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String LINE_DIVIDER = "---";

    public static void printLottos(Lottos lottos) {
        System.out.println(NotificationMessage.PURCHASED_LOTTOS.format(lottos.size()));

        System.out.println(lottos);

        System.out.println(NotificationMessage.DIVIDER.getMessage());
    }

    public static void printResults(List<Prize> results, int purchaseAmount) {
        System.out.println(NotificationMessage.DIVIDER.getMessage());

        System.out.println(WINNING_STATISTICS);
        System.out.println(LINE_DIVIDER);

        int totalPrize = 0;

        List<Prize> reversedPrizes = Arrays.asList(Prize.values());
        Collections.reverse(reversedPrizes);

        for (Prize prize : reversedPrizes) {
            long count = results.stream().filter(p -> p == prize).count();
            if (prize != Prize.NONE) {
                System.out.println(prize.getDescription(count));
                totalPrize += count * prize.getPrizeMoney();
            }
        }

        double profitRate = calculateProfitRate(totalPrize, purchaseAmount);
        System.out.print(NotificationMessage.PROFIT_RATE.format(profitRate));
    }

    private static double calculateProfitRate(int totalPrize, int purchaseAmount) {
        return (double) totalPrize / purchaseAmount * 100;
    }
}
