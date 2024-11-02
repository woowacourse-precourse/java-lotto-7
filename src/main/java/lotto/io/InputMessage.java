package lotto.io;

public class InputMessage {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static void purchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public static void winningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }
}
