package lotto.view;

public class InputView {
    private static final String PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static void requestPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_MESSAGE);
    }

    public static void requestWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public static void requestBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

}
