package lotto;

import static lotto.MessageContainer.ENTER_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }
}
