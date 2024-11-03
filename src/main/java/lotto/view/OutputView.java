package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoWinnerPrize;
import lotto.model.PurchasedLotto;

import java.util.List;

public class OutputView {

    private static final String PURCHASED_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String END_OF_PRIZE_MESSAGE = "개";
    public static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String RATE_OF_RESULT = "총 수익률은 %.1f%%입니다.";

    public static void printPurchasedLottos(PurchasedLotto purchasedLotto) {
        List<Lotto> lottos = purchasedLotto.getLottos();
        promptPurchaseAmountResult(lottos.size());
        printLottoNumbers(lottos);
        printLine();
    }

    public static void printPrizeCount(LottoWinnerPrize prize, int count) {
        System.out.println(prize.getDescription() + count + END_OF_PRIZE_MESSAGE);
    }

    public static void promptWINNING_STATISTICS() {
        System.out.println(WINNING_STATISTICS);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RESULT, rateOfReturn);
    }

    private static void promptPurchaseAmountResult(int amount) {
        System.out.println(amount + PURCHASED_AMOUNT_MESSAGE);
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static void printLine() {
        System.out.println();
    }

}
