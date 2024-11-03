package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.UserLotto;

public class OutputView {
    private static final String PRINT_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String PRINT_RESULT_STATISTICS_TITLE = "당첨 통계";
    private static final String PRINT_3LINES = "---";
    private static final String PRINT_MATCH_3_NUMBERS = "3개 일치 (5,000원) - ";
    private static final String PRINT_MATCH_4_NUMBERS = "4개 일치 (5,0000원) - ";
    private static final String PRINT_MATCH_5_NUMBERS = "5개 일치 (1,500,000원) -";
    private static final String PRINT_MATCH_5_NUMBERS_NOT_EQUAL_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_MATCH_6_NUMBERS = "6개 일치 (2,000,000,000원) - ";
    private static final String PRINT_RESULT_STATISTICS = "총 수익률은";
    private static final String PRINT_WINNING_LOTTO_COUNT = "개";
    private static final String PRINT_PERCENT = "%입니다.";
    public void printLottoCount(int price) {
        System.out.println(price / 1000 + PRINT_LOTTO_COUNT);
    }

    private void printUserLottoNumbers(List<Lotto> lottos) {
        int lastIndex = lottos.size() - 1;
        System.out.print("[");
        for (Lotto lotto : lottos) {
            if (lottos.get(lastIndex) == lotto) {
                System.out.print(lottos + "]");
            }
            System.out.print(lottos + ", ");
        }
    }

    private void printResultStatistics(UserLotto userLotto) {
        int n = 0; // UserLotto 구현후 수정예정
        System.out.println(PRINT_RESULT_STATISTICS_TITLE);
        System.out.println(PRINT_3LINES);
        System.out.println(PRINT_MATCH_3_NUMBERS + n + PRINT_WINNING_LOTTO_COUNT);
        System.out.println(PRINT_MATCH_4_NUMBERS + n + PRINT_WINNING_LOTTO_COUNT);
        System.out.println(PRINT_MATCH_5_NUMBERS + n + PRINT_WINNING_LOTTO_COUNT);
        System.out.println(PRINT_MATCH_5_NUMBERS_NOT_EQUAL_BONUS + n + PRINT_WINNING_LOTTO_COUNT);
        System.out.println(PRINT_MATCH_6_NUMBERS + n + PRINT_WINNING_LOTTO_COUNT);
        System.out.println(PRINT_RESULT_STATISTICS+ n + PRINT_PERCENT);
    }
}
