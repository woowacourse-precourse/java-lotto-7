package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class OutputView {
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void outputPurchaseAmount(int count) {
        System.out.println();
        System.out.printf(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public void printWinningResult(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printWinningDetail(result);
        printProfitRate(result);
    }

    private void printWinningDetail(LottoResult result) {
        result.getRankCounts().forEach((rank, count) -> {
            if (rank != LottoRank.NONE) {
                System.out.printf("%s (%,d원) - %d개%n",
                        rank.getDescription(),
                        rank.getAmount(),
                        count);
            }
        });
    }

    private void printProfitRate(LottoResult result) {
        System.out.printf(PROFIT_RATE_MESSAGE + "%n", result.calculateProfitRate());
    }
}
