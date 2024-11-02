package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class OutputView {
    private static final String WINNING_STATISTICS_HEADER = """
            당첨 통계
            ---""";
    private static final String WINNING_STATISTICS_FORMAT = "%s - %d개";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseResult(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.toString());
    }

    public void printWinningStatistics(Map<Prize, Integer> result) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_HEADER);

        List<Prize> sortedPrizes = Arrays.asList(
                Prize.FIFTH,    // 3개 일치
                Prize.FOURTH,   // 4개 일치
                Prize.THIRD,    // 5개 일치
                Prize.SECOND,   // 5개 일치 + 보너스
                Prize.FIRST     // 6개 일치
        );

        sortedPrizes.forEach(prize ->
                System.out.printf(WINNING_STATISTICS_FORMAT + "%n",
                        prize,
                        result.getOrDefault(prize, 0))
        );
    }

    public void printReturnRate(double returnRate) {
        System.out.printf(RETURN_RATE_FORMAT, returnRate);
    }
}
