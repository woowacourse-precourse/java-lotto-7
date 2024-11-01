package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readMoney() {
        InputPrompt.printMoneyInPutMessage();
        String moneyInput = readInput();
        InputValidator.validateMoneyInput(moneyInput);
        return moneyInput;
    }

    public String setWinningNumbers() {
        InputPrompt.printWinningNumbersInputMessage();
        String winningNumbers = readInput();
        return winningNumbers;
    }

    public String setBonusNumber() {
        InputPrompt.printBonusNumberInputMessage();
        String bonusNumber = readInput();
        return bonusNumber;
    }

    private String readInput() {
        return Console.readLine();
    }
}
