package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_INPUT.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
