package lotto.wrapper;

import lotto.util.Parse;
import lotto.util.constants.LottoConstants;
import lotto.util.validator.LottoValidator;

public class Amount {

    private final int amount;

    private Amount(String inputAmount) {
        int amount = Parse.stringToInt(inputAmount);
        validate(amount);
        this.amount = amount;
    }

    public static Amount of(String inputAmount) {
        return new Amount(inputAmount);
    }

    private void validate(int amount) {
        LottoValidator.validatePrice(amount);
        LottoValidator.validateDivisible(amount);
    }

    public int toLottoCount() {
        return amount / LottoConstants.PER_AMOUNT.getValue();
    }

}
