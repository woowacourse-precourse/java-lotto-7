package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static String ENTER_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static String ENTER_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static String ENTER_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public String printEnterPurchasePriceMessage() {
        printMessage(ENTER_PURCHASE_PRICE_MESSAGE);
        return Console.readLine();
    }

    public String printEnterWinningNumberMessage() {
        printMessage(ENTER_WINNING_NUMBER);
        return Console.readLine();
    }

    public String printBonusNumberMessage() {
        printMessage(ENTER_BONUS_NUMBER);
        return Console.readLine();
    }

    private void printMessage(final String message) {
        System.out.println(message);
    }
}
