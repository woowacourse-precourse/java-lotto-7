package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPurchaseAmount() {
        String purchaseAmountInput = Console.readLine();
        validateEmptyInput(purchaseAmountInput);
        return purchaseAmountInput;
    }

    private void validateEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 비었습니다.");
        }
    }
}
