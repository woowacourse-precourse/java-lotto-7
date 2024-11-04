package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputMessage;

public class InputView {
    public String readPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.getInputMessage());
        return Console.readLine();
    }

    public String readWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS.getInputMessage());
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER.getInputMessage());
        return Console.readLine();
    }
}
