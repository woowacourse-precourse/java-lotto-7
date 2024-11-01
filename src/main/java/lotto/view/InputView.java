package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputMessage;

public class InputView {
    public String readPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String readWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER);
        return Console.readLine();
    }
}
