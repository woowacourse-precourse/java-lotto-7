package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPurchaseAmount() {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT.getInputMessage());
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS.getInputMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getInputMessage());
        return Console.readLine();
    }

    public void consoleClose() {
        Console.close();
    }
}
