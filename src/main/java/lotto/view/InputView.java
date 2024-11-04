package lotto.view;

public class InputView {
    private static final String DISPLAY_REQUEST_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String DISPLAY_REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String DISPLAY_REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void requestPurchasePriceMessage() {
        System.out.println(DISPLAY_REQUEST_PURCHASE_PRICE_MESSAGE);
    }

    public void requestWinningNumberMessage() {
        System.out.println(DISPLAY_REQUEST_WINNING_NUMBER_MESSAGE);
    }

    public void requestBonusNumberMessage() {
        System.out.println(DISPLAY_REQUEST_BONUS_NUMBER_MESSAGE);
    }
}
