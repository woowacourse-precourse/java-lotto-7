package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();

        return Integer.parseInt(purchaseAmount);
    }
}
