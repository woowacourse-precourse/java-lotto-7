package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {

    private static final String LOTTO_COUNT_MESSAGE = "%d개의 로또를 구매했습니다.";
    private static final String LOTTO_NUMBERS_MESSAGE = "로또 번호: ";
    private static final String RESULTS_HEADER = "\n당첨 통계";
    private static final String RESULTS_DIVIDER = "---";
    private static final String RANK_RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String TOTAL_EARNINGS_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void displayLottoCount(int count) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, count));
    }

    public void displayLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(LOTTO_NUMBERS_MESSAGE + lotto.getNumbers());
        }
    }

    public void displayResults(Map<Rank, Integer> results, double totalEarningsRate) {
        System.out.println(RESULTS_HEADER);
        System.out.println(RESULTS_DIVIDER);

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue; // 당첨되지 않은 등급은 출력하지 않음
            }
            int count = results.getOrDefault(rank, 0);
            System.out.printf(RANK_RESULT_MESSAGE, rank.getMatchCount(), rank.getPrize(), count);
            System.out.println();
        }

        System.out.printf(TOTAL_EARNINGS_MESSAGE, totalEarningsRate);
        System.out.println();
    }
}
