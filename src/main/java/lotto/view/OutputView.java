package lotto.view;

import static lotto.util.message.OutputMessage.OUTPUT_BONUS_NUMBER_SAME;
import static lotto.util.message.OutputMessage.OUTPUT_PURCHASED_LOTTO_COUNT;
import static lotto.util.message.OutputMessage.OUTPUT_REWARDS_AND_LOTTO_COUNT;
import static lotto.util.message.OutputMessage.OUTPUT_SAME_LOTTO_NUMBER_COUNT;
import static lotto.util.message.OutputMessage.OUTPUT_TOTAL_PROFIT_PERCENTAGE;
import static lotto.util.message.OutputMessage.OUTPUT_WINNING_STATISTIC_TITLE;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public class OutputView {

    public void displayLottoNumbers(List<Lotto> purchased) {
        System.out.printf(OUTPUT_PURCHASED_LOTTO_COUNT, purchased.size());
        for (Lotto lotto : purchased) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayLottoSummary(Map<LottoRank, Integer> winningCount, Double profit) {
        System.out.println(OUTPUT_WINNING_STATISTIC_TITLE);
        for (LottoRank rank : LottoRank.getWinningRanks()) {
            System.out.println(makeString(rank, winningCount.getOrDefault(rank, 0)));
        }
        System.out.printf(OUTPUT_TOTAL_PROFIT_PERCENTAGE, profit);
    }

    public String makeString(LottoRank rank, Integer winningCount) {
        StringBuilder lottoRankInfo = new StringBuilder();

        lottoRankInfo.append(String.format(OUTPUT_SAME_LOTTO_NUMBER_COUNT, rank.getSameNumberCount()));
        if (rank.isSecondRank()) {
            lottoRankInfo.append(OUTPUT_BONUS_NUMBER_SAME);
        }
        lottoRankInfo.append(String.format(OUTPUT_REWARDS_AND_LOTTO_COUNT, rank.getReward(), winningCount));

        return lottoRankInfo.toString();
    }
}
