package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchasePrice;
import lotto.util.Converter;
import lotto.validation.PriceValidator;

public class InputView {

    public static PurchasePrice inputPurchasePrice() {
        String input = Console.readLine();
        PriceValidator.validatePrice(input);
        return new PurchasePrice(input);
    }
}
