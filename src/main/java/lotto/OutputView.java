package lotto;

public class OutputView {
    private static final String ENTER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NOTIFY_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER_WINNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void notifyEnterMoneyToBuy() {
        System.out.println(ENTER_MONEY_MESSAGE);
    }

    public static void notifyAmount(int amount) {
        System.out.println(amount + NOTIFY_AMOUNT_MESSAGE);
    }

    public static void notifyEnterWinningMoney() {
        System.out.println(ENTER_WINNING_NUM_MESSAGE);
    }

    public static void notifyEnterBonusMoney() {
        System.out.println(ENTER_BONUS_NUM_MESSAGE);
    }
}
