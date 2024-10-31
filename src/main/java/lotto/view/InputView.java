package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;

public class InputView {
    private final static String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public PurchaseAmount readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        final String input = Console.readLine();
        final int validateNumber = inputHandler.validateNumber(input);
        return new PurchaseAmount(validateNumber);
    }
}
