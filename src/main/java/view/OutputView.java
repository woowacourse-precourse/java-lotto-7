package view;

import domain.Lotto;
import domain.Rank;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void outputPurchaseLottoAmount(List<Lotto> lottos) {
        ViewMessage.OUTPUT_PURCHASE_LOTTO_AMOUNT.print(lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getAscNumber()));
    }

    public void outputWinningStatistics(Map<Rank, Long> rankResult) {
        ViewMessage.OUTPUT_WINNING_STATISTIC.print();
        ViewMessage.OUTPUT_FIFTH_STATISTIC.print(rankResult.getOrDefault(Rank.FIFTH, 0L));
        ViewMessage.OUTPUT_FOURTH_STATISTIC.print(rankResult.getOrDefault(Rank.FOURTH, 0L));
        ViewMessage.OUTPUT_THIRD_STATISTIC.print(rankResult.getOrDefault(Rank.THIRD, 0L));
        ViewMessage.OUTPUT_SECOND_STATISTIC.print(rankResult.getOrDefault(Rank.SECOND, 0L));
        ViewMessage.OUTPUT_FIRST_STATISTIC.print(rankResult.getOrDefault(Rank.FIRST, 0L));
    }

    public void outputRateOfReturn(double rateOfReturn) {
        ViewMessage.OUTPUT_RATE_OF_RETURN.print(rateOfReturn);
    }
}
