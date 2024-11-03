package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.Message;

public class InputView {
    public String InputPurchaseMoney() {
        Message.INPUT_PURCHASE_MONEY.println();
        return Console.readLine();
    }
}
