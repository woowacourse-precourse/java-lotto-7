package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String SEPARATOR_LINE = "---";

    public static void println(String message) {
        System.out.println(message);
    }

    private static void printLotto(Lotto lotto) {
        println(lotto.getNumbers().toString());
    }
}
