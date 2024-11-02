package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PurchaseAmount {

    public int input() {
        InputMessageEnum.PURCHASE_AMOUNT.printMessage();
        String purchaseAmount = readLine();
        return Integer.parseInt(purchaseAmount);
    }
}
