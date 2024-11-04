package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    private static final String PURCHASED_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String COUNt_SUFFIX = "개";
    public static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String RATE_OF_RESULT = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseAmount(int quantity) {
        printLine();
        System.out.println(quantity + PURCHASED_AMOUNT_MESSAGE);
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        printLottoNumbers(lottos);
        printLine();
    }

    public static void printPrizeCount(String prizeDescription, int count) {
        System.out.println(prizeDescription + count + COUNt_SUFFIX);
    }

    public static void promptWINNING_STATISTICS() {
        printLine();
        System.out.println(WINNING_STATISTICS);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RESULT, rateOfReturn);
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static void printLine() {
        System.out.println();
    }

}
