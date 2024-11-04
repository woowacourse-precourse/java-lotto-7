package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.UserLotto;
import lotto.enums.LottoPrizes;

public class OutputView {
    private static final String PRINT_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String PRINT_RESULT_STATISTICS_TITLE = "당첨 통계";
    private static final String PRINT_3LINES = "---";
    private static final String PRINT_MATCH_NUMBERS = "개 일치 (";
    private static final String PRINT_MATCH_NUMBERS_SECOND = "개 일치, 보너스 볼 일치 (";
    private static final String PRINT_PRIZE = "원) - ";
    private static final String PRINT_RESULT_STATISTICS = "총 수익률은";
    private static final String PRINT_WINNING_LOTTO_COUNT = "개";
    private static final String PRINT_PERCENT = "%입니다.";
    public void printLottoCount(int price) {
        System.out.println();
        System.out.println(price / 1000 + PRINT_LOTTO_COUNT);

    }

    public void printUserLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResultStatistics() {
        System.out.println(PRINT_RESULT_STATISTICS_TITLE);
        System.out.println(PRINT_3LINES);
        for (LottoPrizes prize : LottoPrizes.values()) {
            if (prize == LottoPrizes.SECOND) {
                System.out.println(prize.getMatchNumberCount() + PRINT_MATCH_NUMBERS_SECOND + prize.getPrizeMoney() + PRINT_PRIZE + prize.getCount() + PRINT_WINNING_LOTTO_COUNT);
            }
            System.out.println(prize.getMatchNumberCount() + PRINT_MATCH_NUMBERS + prize.getPrizeMoney() + PRINT_PRIZE + prize.getCount() + PRINT_WINNING_LOTTO_COUNT);
        }
        System.out.println(PRINT_RESULT_STATISTICS+ n + PRINT_PERCENT);
    }
}
