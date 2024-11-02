package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.PurchasedLottos;
import lotto.domain.result.WinningResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASE_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_RESULT_PREFIX = "\n당첨 통계\n---\n";
    private static final String WINNING_RESULT_MESSAGE = "%d개 일치 (%,d원) - %d개\n";
    private static final String SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String PROFIT_RATE_RESULT_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public void printPurchasedLottos(PurchasedLottos purchasedLottos) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, purchasedLottos.getPurchasedLottos().size());
        printLottoNumbers(purchasedLottos.getPurchasedLottos());
    }

    private void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningStatistics(WinningResult winningResult) {
        System.out.print(WINNING_RESULT_PREFIX);
        printWinningResults(winningResult.getLottoResult());
        printProfitRate(winningResult);
    }

    private void printWinningResults(Map<LottoRank, Integer> rankCount) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> printRankResult(rank, rankCount.getOrDefault(rank, 0)));
    }

    private void printRankResult(LottoRank rank, int count) {
        if (rank == LottoRank.SECOND) {
            System.out.printf(SECOND_RANK_MESSAGE, rank.getPrice(), count);
            return;
        }
        System.out.printf(WINNING_RESULT_MESSAGE, rank.getMatchCount(), rank.getPrice(), count);
    }

    private void printProfitRate(WinningResult winningResult) {
        System.out.printf(PROFIT_RATE_RESULT_MESSAGE, getProfitRate(winningResult));
    }

    private double getProfitRate(WinningResult winningResult) {
        return winningResult.getRevenue()
                .calculateProfitRate();
    }
}
