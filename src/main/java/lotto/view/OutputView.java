package lotto.view;

public class OutputView extends OutputWriter {
    public void requestLottoMoney() {
        displayMessage("구입금액을 입력해 주세요.");
    }

    public void displayPurchaseQuantity(int quantity) {
        displayNewLine();
        displayMessage(quantity + "개를 구매했습니다.");
    }

    public void displayPurchasedLottos(String purchasedLottos) {
        displayMessage(purchasedLottos);
    }

    public void requestWinningNumber() {
        displayNewLine();
        displayMessage("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        displayNewLine();
        displayMessage("보너스 번호를 입력해 주세요.");
    }

    public void displayWinningStatistics(String winningResult, String profit) {
        displayNewLine();
        displayMessage("당첨 통계");
        displayMessage("---");
        displayMessage(winningResult);
        displayMessage(profit);
    }
}
