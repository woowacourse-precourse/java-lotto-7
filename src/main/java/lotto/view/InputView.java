package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.validator.InputValidator;

public class InputView {

    public PurchaseAmount readPurchasePrice() {
        String input = Console.readLine();
        InputValidator.validateNumber(input);
        return new PurchaseAmount(Integer.parseInt(input));
    }
}
