package lotto.view;

import lotto.constant.OutputMessage;

public class OutputView {

    public void printPurchaseGuide() {
        System.out.println(OutputMessage.PURCHASE_GUIDE.getMessage());
    }

    public void printPurchaseAmount(int amount) {
        System.out.println(String.format(OutputMessage.PURCHASE_AMOUNT.getMessage(), amount));
    }

    public void printLotto(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printWinningNumberGuide() {
        System.out.println(OutputMessage.WINNING_NUMBER_GUIDE.getMessage());
    }

    public void printBonusNumberGuide() {
        System.out.println(OutputMessage.BONUS_GUID.getMessage());
    }

    public void printLottoResult(String resultScreen) {
        System.out.println(OutputMessage.RESULT_GUIDE.getMessage());
        System.out.println(OutputMessage.LINE.getMessage());
        System.out.println(resultScreen);
    }

    public void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public void printNewLine() {
        System.out.println();
    }
}
