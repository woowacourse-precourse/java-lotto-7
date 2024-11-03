package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {
    private static final String OUTPUT_LOTTOS = "\n%d개를 구매했습니다.\n";
    private static final String OUTPUT_WINNING_RESULT = "\n당첨 통계\n---";
    private static final String OUTPUT_PROFIT_RATE = "총 수익률은 %,.1f%%입니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(OUTPUT_LOTTOS, lottos.size());
        for (final Lotto lotto : lottos) {
            final List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    public void printWinningResult(List<LottoRank> winningResult) {
        System.out.println(OUTPUT_WINNING_RESULT);
        for (final LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.SIXTH) {
                continue;
            }
            final int count = Collections.frequency(winningResult, lottoRank);
            System.out.printf(lottoRank.getMessage(), count);
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(OUTPUT_PROFIT_RATE, profitRate);
    }
}
