package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    public static void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
    }

    public static void printPurchaseLottoCount(int Count) {
        System.out.println(System.lineSeparator() + Count + PURCHASE_LOTTO_COUNT);
    }

    public static void printEachLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void printWinningNumberInputMessage() {
        System.out.println(System.lineSeparator() + WINNING_NUMBER_INPUT);
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(System.lineSeparator() + BONUS_NUMBER_INPUT);
    }
}
