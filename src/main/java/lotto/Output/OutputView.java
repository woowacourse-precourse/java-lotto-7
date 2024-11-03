package lotto.Output;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class OutputView {
    private static final String WINNING_STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printWinningStatistics(LottoResult result) {
        System.out.println(WINNING_STATISTICS_HEADER);
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> printRankStatistics(rank, result.getCountByRank(rank)));
        System.out.printf(PROFIT_RATE_FORMAT, result.calculateProfitRate());
    }

    private void printRankStatistics(LottoRank rank, int count) {
        System.out.printf("%s (%,d원) - %d개\n",
                rank.getDescription(),
                rank.getPrize(),
                count
        );
    }
}
