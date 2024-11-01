package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final PrintMessage message = new PrintMessage();

    public String purchaseAmountInput() {
        message.getPurchaseAmountMessage();
        return readInput();
    }

    public String winningNumbersInput() {
        message.getWinningNumbersMessage();
        return readInput();
    }

    public String bonusNumberInput() {
        message.getBonusNumberMessage();
        return readInput();
    }

    private String readInput() {
        return Console.readLine().trim();
    }
}
