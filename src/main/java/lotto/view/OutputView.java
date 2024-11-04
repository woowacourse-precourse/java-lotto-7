package lotto.view;

import lotto.common.IOMessage;
import lotto.common.LottoRank;
import lotto.controller.LottoGame;
import lotto.domain.Lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(IOMessage.LOTTO_COUNT_MESSAGE, lottos.size());
        lottos.forEach(OutputView::printLottoNumbers);
    }

    private static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printStatistics(Map<LottoRank, Integer> result, int purchaseAmount, double totalProfit) {
        System.out.println(IOMessage.STATISTICS_TITLE);
        printRankStatistics(result);
        printProfitRate(totalProfit, purchaseAmount);
    }
    private static void printRankStatistics(Map<LottoRank, Integer> result) {
        for (LottoRank rank : LottoRank.values()) {
            int count = result.getOrDefault(rank, 0);
            if (rank != LottoRank.NONE) {
                printRankResult(rank, count);
            }
        }
    }

    private static String getRankResultFormat(LottoRank rank) {
        if (rank.isMatchBonus()) {
            return IOMessage.BONUS_MATCH_RESULT;
        }
        return IOMessage.NORMAL_MATCH_RESULT;
    }

    private static void printRankResult(LottoRank rank, int count) {
        String format = getRankResultFormat(rank);
        System.out.printf(format, rank.getMatchCount(), numberFormat.format(rank.getPrize()), count);
    }

    private static void printProfitRate(double totalProfit, int purchaseAmount) {
        double profitRate = (totalProfit / purchaseAmount) * 100;
        System.out.printf(IOMessage.TOTAL_PROFIT_MESSAGE, profitRate);
    }
}

