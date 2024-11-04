package lotto.view;

public class InputView {
    private static String PRINT_INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static String PRINT_INPUT_PRIZE_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String PRINT_INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void getPrintInputBonusNumberMessage() {
        System.out.println(PRINT_INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void getPrintInputPurchaseMessage() {
        System.out.println(PRINT_INPUT_PURCHASE_MONEY_MESSAGE);
    }

    public static void getPrintInputPrizeNumberMessage() {
        System.out.println(PRINT_INPUT_PRIZE_NUMBER_MESSAGE);
    }

}
