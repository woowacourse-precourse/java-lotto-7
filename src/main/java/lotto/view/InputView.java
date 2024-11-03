package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.Message;

public class InputView {
    public String readPurchaseMoney() {
        Message.INPUT_PURCHASE_MONEY.println();
        return Console.readLine();
    }
}
