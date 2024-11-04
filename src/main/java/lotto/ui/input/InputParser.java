package lotto.ui.input;

import java.util.Arrays;
import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.PurchaseAmount;

public class InputParser {

    public PurchaseAmount parsePurchaseAmount(String amount) {
        int parsedAmount = Integer.parseInt(amount);
        return new PurchaseAmount(parsedAmount);
    }

    public List<Integer> parseWinningNumbers(String delimiter, String numbers) {
        return Arrays
                .stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    public BonusNumber parseBonusNumber(String number) {
        int parsedNumber = Integer.parseInt(number);
        return new BonusNumber(parsedNumber);
    }
}
