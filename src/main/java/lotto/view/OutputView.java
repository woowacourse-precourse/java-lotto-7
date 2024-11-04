package lotto.view;

import static lotto.common.AppConstant.PROFIT_STRATEGY_FORMAT;
import static lotto.model.LottoRank.*;
import static lotto.view.ViewConstant.BOUGHT_COUNT_FORMAT;
import static lotto.view.ViewConstant.LOTTO_STATISTIC_PREFIX;
import static lotto.view.ViewConstant.MATCH_BONUS_NUMBER_COMMENT;
import static lotto.view.ViewConstant.MATCH_COUNT_SUFFIX;
import static lotto.view.ViewConstant.PRIZE_FORMAT;
import static lotto.view.ViewConstant.TOTAL_PROFIT_RATIO_FORMAT;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoStatistic;

public class OutputView {
    public void printBoughtLottoList(List<Lotto> lottoList) {
        int count = lottoList.size();

        System.out.printf(BOUGHT_COUNT_FORMAT, count);

        lottoList.forEach((lotto -> {
            System.out.println(lotto.getNumbers());
        }));

        System.out.println();
    }

    public void printLottoStatistic(LottoStatistic lottoStatistic) {
        HashMap<LottoRank, Integer> winningResult = lottoStatistic.getWinningResult();
        double profitRatio = lottoStatistic.getProfitRatio();
        DecimalFormat decimalFormat = new DecimalFormat(PROFIT_STRATEGY_FORMAT);
        String roundedProfitRatio = decimalFormat.format(profitRatio);

        System.out.println(LOTTO_STATISTIC_PREFIX);
        printEachResult(winningResult);
        System.out.printf(TOTAL_PROFIT_RATIO_FORMAT, roundedProfitRatio);
    }

    private void printEachResult(HashMap<LottoRank, Integer> winningResult) {
        List<LottoRank> printRankList = List.of(RANK_5, RANK_4, RANK_3, RANK_2, RANK_1);
        DecimalFormat decimalFormat = new DecimalFormat();

        printRankList.forEach(rank -> {
            Integer winCount = winningResult.get(rank);
            String decimalPrizeMoney = decimalFormat.format(rank.prizeMoney);
            System.out.print(rank.matchCount + MATCH_COUNT_SUFFIX);

            if (rank.matchBonus) {
                System.out.print(MATCH_BONUS_NUMBER_COMMENT);
            }

            System.out.printf(PRIZE_FORMAT, decimalPrizeMoney, winCount);
        });
    }

    public void printException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
