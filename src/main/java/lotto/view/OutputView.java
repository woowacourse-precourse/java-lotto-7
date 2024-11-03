package lotto.view;

import static lotto.util.message.OutputMessage.OUTPUT_BONUS_NUMBER_SAME;
import static lotto.util.message.OutputMessage.OUTPUT_PURCHASED_LOTTO_COUNT;
import static lotto.util.message.OutputMessage.OUTPUT_REWARDS_AND_LOTTO_COUNT;
import static lotto.util.message.OutputMessage.OUTPUT_SAME_LOTTO_NUMBER_COUNT;
import static lotto.util.message.OutputMessage.OUTPUT_TOTAL_PROFIT_PERCENTAGE;
import static lotto.util.message.OutputMessage.OUTPUT_WINNING_STATISTIC_TITLE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public class OutputView {

    public void displayLottoNumbers(List<Lotto> purchased) {
        System.out.printf(OUTPUT_PURCHASED_LOTTO_COUNT, purchased.size());
        purchased.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayLottoStatistic(Map<LottoRank, Long> winningCount, Double profit) {
        System.out.println(OUTPUT_WINNING_STATISTIC_TITLE);

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> System.out.print(makeToString(rank, winningCount.getOrDefault(rank, 0L))));

        System.out.printf(OUTPUT_TOTAL_PROFIT_PERCENTAGE, profit);
    }

    public String makeToString(LottoRank rank, Long winningCount) {
        StringBuilder lottoRankInfo = new StringBuilder();

        lottoRankInfo.append(String.format(OUTPUT_SAME_LOTTO_NUMBER_COUNT, rank.getSameNumberCount()));
        if (rank.isSecondRank()) {
            lottoRankInfo.append(OUTPUT_BONUS_NUMBER_SAME);
        }
        lottoRankInfo.append(String.format(OUTPUT_REWARDS_AND_LOTTO_COUNT, rank.getProfit(), winningCount));

        return lottoRankInfo.toString();
    }
}
