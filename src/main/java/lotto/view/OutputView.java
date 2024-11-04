package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String PURCHASED_LOTTOS_MSG = "%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "당첨 통계\n---";
    private static final String YIELD_MSG = "총 수익률은 %.1f%%입니다.";

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(String.format(PURCHASED_LOTTOS_MSG, lottos.size()));
        lottos.forEach(OutputView::printLottoNumbers);
    }

    private static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printWinningStatistics(Map<Rank, Integer> results) {
        System.out.println(STATISTICS_HEADER);
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE && rank.getPrize() > 0)
                .sorted(Comparator.comparingInt(Rank::getMatchCount).
                        thenComparing(Rank::isBonusRequired))
                .forEach(rank -> System.out.printf("%s - %d개\n", rank.getDisplayMessage(), results.getOrDefault(rank, 0)));
    }

    public static void printYield(double yield) {
        System.out.printf(YIELD_MSG, yield);
    }
}
