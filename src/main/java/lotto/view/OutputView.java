package lotto.view;

import lotto.common.ViewConstant;
import lotto.model.LottoPrize;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottos(List<String> lottos, int lottoCount) {
        System.out.printf(ViewConstant.OUTPUT_LOTTO_COUNT_MESSAGE, lottoCount);
        System.out.println();
        lottos.forEach(System.out::println);
    }

    public void printWinningStatistics(Map<LottoPrize, Integer> prizeCounts) {
        System.out.println(ViewConstant.OUTPUT_WINNING_STATISTICS_MESSAGE);
        System.out.println(ViewConstant.THREE_DASH);

        for (LottoPrize prize : LottoPrize.values()) {
            int count = prizeCounts.getOrDefault(prize, 0);
            printRankMessage(prize, count);
        }
    }

    private void printRankMessage(LottoPrize prize, int count) {

        if (prize.getPrizeAmount() == 0) return;

        StringBuilder matchMessage = new StringBuilder();
        matchMessage.append(prize.getMatchCount()).append(ViewConstant.OUTPUT_MATCHING_NUMBERS_MESSAGE);
        if (prize.hasBonus()) {
            matchMessage.append(ViewConstant.OUTPUT_MATCHING_BONUS_MESSAGE);
        }
        matchMessage.append(ViewConstant.OPEN_PARENTHESES)
                .append(String.format("%,d", prize.getPrizeAmount()))
                .append(ViewConstant.OUTPUT_MONEY_UNIT)
                .append(ViewConstant.CLOSE_PARENTHESES)
                .append(ViewConstant.DASH)
                .append(count)
                .append(ViewConstant.OUTPUT_NUMBER_UNIT);

        System.out.println(matchMessage);
    }


    public void printProfit(double profit) {
        System.out.printf(ViewConstant.OUTPUT_PROFIT_RATE_MESSAGE, profit);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
