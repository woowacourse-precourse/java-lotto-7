package lotto.View;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String LOTTO_NUMBERS = "발행한 로또 번호:";
    private static final String LOTTO_STATISTICS = "당첨 통계\n---";
    private static final String RESULTS_FORMAT = "6개 일치 (2,000,000,000원) - %d개" +
            "\n5개 일치, 보너스 볼 일치 (30,000,000원) - %d개" +
            "\n5개 일치 (1,500,000원) - %d개" +
            "\n4개 일치 (50,000원) - %d개" +
            "\n3개 일치 (5,000원) - %d개";
    private static final String ROUND_RESULT_FORMAT = "총 수익률은 : %.2f%%입니다.\n";

    public static void displayLottoNumbers(List<Lotto> lottos) {
        System.out.println(LOTTO_NUMBERS);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void displayLottoStatistics() {
        System.out.println(LOTTO_STATISTICS);
    }

    public static void displayPrizeResults(int firstPrizeCount, int secondPrizeCount,
                                           int thirdPrizeCount, int fourthPrizeCount, int fifthPrizeCount) {
        System.out.printf(RESULTS_FORMAT, firstPrizeCount, secondPrizeCount, thirdPrizeCount, fourthPrizeCount,
                fifthPrizeCount);
    }

    public static void displayRounds(double round) {
        System.out.println();
        System.out.printf(ROUND_RESULT_FORMAT, round);
    }
}