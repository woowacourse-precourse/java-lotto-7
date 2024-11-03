package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.utils.Constant;

public class OutputView {

    private final DecimalFormat prizeMoneyFormat = new DecimalFormat("#,###");
    private final DecimalFormat yieldFormat = new DecimalFormat("#,##0.0");

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(Constant.PURCHASE_COUNT_MESSAGE, lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningStats(Map<LottoRank, Integer> winningStats) {
        System.out.println(Constant.WINNING_STATS_HEADER);
        System.out.println(Constant.WINNING_STATS_SEPARATOR);

        winningStats.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.NONE)
                .forEach(entry -> {
                    LottoRank rank = entry.getKey();
                    int count = entry.getValue();
                    String formattedPrizeMoney = prizeMoneyFormat.format(rank.getPrizeMoney());

                    if (rank == LottoRank.SECOND) {
                        System.out.printf(Constant.MATCH_SECOND_MESSAGE,
                                rank.getMatchCount(), formattedPrizeMoney, count);
                        return;
                    }

                    System.out.printf(Constant.MATCH_MESSAGE,
                            rank.getMatchCount(), formattedPrizeMoney, count);
                });
    }

    public void printYield(double yield) {
        String formattedYield = yieldFormat.format(yield);
        System.out.printf(Constant.YIELD_MESSAGE, formattedYield);
    }
}
