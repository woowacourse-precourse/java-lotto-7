package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.IOMessage;

public class InputView {
    public String readMoney() {
        System.out.println(IOMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        String money = Console.readLine();
        return money.replace(" ", "");
    }

    public String readWinningNumbers() {
        System.out.println(IOMessage.INPUT_WINNING_NUMBER.getMessage());
        String winningNumbers = Console.readLine();
        return winningNumbers.replace(" ", "");
    }

    public String readBonusNumber() {
        System.out.println(System.lineSeparator() + IOMessage.INPUT_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();
        return bonusNumber.replace(" ", "");
    }
}
