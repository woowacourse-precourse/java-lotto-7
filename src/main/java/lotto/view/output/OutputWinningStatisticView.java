package lotto.view.output;

import static lotto.handler.OutputHandler.OUTPUT_LOTTO_PROFIT;
import static lotto.handler.OutputHandler.OUTPUT_LOTTO_RANK;
import static lotto.handler.OutputHandler.OUTPUT_LOTTO_RANK_BONUS;
import static lotto.handler.OutputHandler.OUTPUT_WINNING_STATISTIC;

import java.util.Map;
import lotto.domain.LottoProfit;
import lotto.domain.LottoRank;
import lotto.domain.Rank;

public class OutputWinningStatisticView {
    public void showWinningStatistic(LottoRank lottoRank, LottoProfit lottoProfit) {
        System.out.println(OUTPUT_WINNING_STATISTIC);
        showLottoRank(lottoRank);
        showLottoProfit(lottoProfit);
    }

    private void showLottoRank(LottoRank lottoRank) {
        Map<Rank, Integer> rankCounts = lottoRank.getLottoRank();

        for (Rank rank : rankCounts.keySet()) {
            if (rank == Rank.SECOND) {
                System.out.printf(OUTPUT_LOTTO_RANK_BONUS, rank.getMatchCount(), rank.getReward(), rankCounts.getOrDefault(rank, 0));
            }
            System.out.printf(OUTPUT_LOTTO_RANK, rank.getMatchCount(), rank.getReward(), rankCounts.getOrDefault(rank, 0));
        }
    }

    private void showLottoProfit(LottoProfit lottoProfit) {
        System.out.printf(OUTPUT_LOTTO_PROFIT, lottoProfit.getLottoProfit());
    }
}
