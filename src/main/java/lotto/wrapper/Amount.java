package lotto.wrapper;

import lotto.util.Parse;
import lotto.util.validator.LottoValidator;

public class Amount {

    private final int amount;


    private Amount(String inputAmount) {
        int amount = Parse.stringToInt(inputAmount);
        LottoValidator.validatePrice(amount);
        this.amount = amount;
    }

    public static Amount of(String inputAmount) {
        return new Amount(inputAmount);
    }

    public int getAmount() {
        return amount;
    }

}
