package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.Message;

public class InputView {
    public String readPurchaseMoney() {
        Message.INPUT_PURCHASE_MONEY.println();
        return Console.readLine();
    }

    public String readWinningNumbers() {
        Message.INPUT_WIN_NUMBER.println();
        return Console.readLine();
    }

    public String readBonusNumber() {
        Message.INPUT_BONUS_NUMBER.println();
        return Console.readLine();
    }
}
