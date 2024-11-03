package lotto.view;

import lotto.domain.Lottos;
import lotto.message.ExceptionMessage;

public class OutputView {
    public static final String REQUEST_PURCHASE_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String PURCHASED_LOTTOS = "개를 구매했습니다.";
    public static void printRequestPurchaseMoneyAmount() {
        printMessage(REQUEST_PURCHASE_MONEY_AMOUNT);
    }

    public static void printPurchasedLottos(int lottoCount, String lottos) {
        printMessage(lottoCount + PURCHASED_LOTTOS);
        printMessage(lottos);
    }

    public static void printException(IllegalArgumentException e) {
        printMessage(ExceptionMessage.PREFIX + e.getMessage());
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
