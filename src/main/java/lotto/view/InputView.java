package lotto.view;

import static lotto.enums.ViewMessage.INPUT_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getLottoPurchaseAmount() {
        printPurchaseAmountMessage();
        return Console.readLine().trim();
    }

    private void printPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
    }


}
