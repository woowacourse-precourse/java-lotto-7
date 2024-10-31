package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.PurchaseAmount;

public class InputView {

    public PurchaseAmount readPurchaseAmount() {
        String input = Console.readLine();
        validateEmptyInput(input);
        return new PurchaseAmount(input);
    }

    private void validateEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 비었습니다.");
        }
    }
}
