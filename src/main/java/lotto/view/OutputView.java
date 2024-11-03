package lotto.view;

public class OutputView extends OutputWriter {
    public static final String REQUEST_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String IS_PURCHASED = "개를 구매했습니다.";
    public static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String STATISTICS_HEADER = "당첨 통계" + System.lineSeparator() + "---";

    public void requestPurchaseMoney() {
        displayMessage(REQUEST_PURCHASE_MONEY);
    }

    public void displayPurchaseQuantity(int quantity) {
        displayNewLine();
        displayMessage(quantity + IS_PURCHASED);
    }

    public void displayPurchasedLottos(String purchasedLottos) {
        displayMessage(purchasedLottos);
    }

    public void requestWinningNumber() {
        displayNewLine();
        displayMessage(REQUEST_WINNING_NUMBER);
    }

    public void requestBonusNumber() {
        displayNewLine();
        displayMessage(REQUEST_BONUS_NUMBER);
    }

    public void displayWinningStatistics(String winningResult, String profit) {
        displayNewLine();
        displayMessage(STATISTICS_HEADER);
        displayMessage(winningResult);
        displayMessage(profit);
    }
}
