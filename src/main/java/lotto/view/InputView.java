package lotto.view;

import static lotto.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.PurchaseAmount;
import lotto.exception.CustomIllegalArgumentException;

public class InputView {

    public PurchaseAmount readPurchaseAmount() {
        String input = Console.readLine();
        validateEmptyInput(input);
        return PurchaseAmount.from(input);
    }

    private void validateEmptyInput(String input) {
        if (input.isBlank()) {
            throw CustomIllegalArgumentException.from(EMPTY_INPUT);
        }
    }
}
