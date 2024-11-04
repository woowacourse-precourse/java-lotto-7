package lotto.view;

import lotto.dto.LottoPurchaseDetails;
import lotto.dto.WinningStatistics;

public class OutputView {
    private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";

    public void printPurchaseAmountRequestMessage() {
        printMessage(PURCHASE_AMOUNT_REQUEST);
    }

    public void printPurchaseDetailsMessage(LottoPurchaseDetails lottoPurchaseDetails) {
        printNewLine();
        printMessage(lottoPurchaseDetails.getPurchaseDetailsMessage());
    }

    public void printExitMessage(String message) {
        printMessage(message);
    }

    public void printWinningNumbersRequestMessage() {
        printMessage(WINNING_LOTTO_NUMBERS_REQUEST);
    }

    public void printBonusNumberRequestMessage() {
        printNewLine();
        printMessage(BONUS_NUMBER_REQUEST);
    }

    public void printWinningStatisticsMessage(WinningStatistics winningStatistics) {
        printNewLine();
        printMessage(winningStatistics.getWinningStatisticsMessage());
    }

    private void printNewLine() {
        printMessage("");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
