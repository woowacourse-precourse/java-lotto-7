package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputMessage;

public class InputView {
    public void printMessage(InputMessage message) {
        System.out.println(message.getMessage());
    }

    public String inputPurchaseAmount() {
        String inputCost = Console.readLine();
        System.out.println();
        return inputCost;
    }

    public String inputWinningNumber() {
        String inputWinningNumber = Console.readLine();
        System.out.println();
        return inputWinningNumber;
    }

    public String inputBonusNumber() {
        String inputBonusNumber = Console.readLine();
        System.out.println();
        return inputBonusNumber;
    }
}
