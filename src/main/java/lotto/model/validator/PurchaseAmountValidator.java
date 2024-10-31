package lotto.model.validator;

import static lotto.exception.InvalidAmountException.INVALID_AMOUNT_MESSAGE;

import lotto.exception.InvalidLottoNumberException;
import lotto.util.LottoConstants;

public class PurchaseAmountValidator implements Validator{
    private final int amount;

    public PurchaseAmountValidator(int amount) {
        this.amount = amount;
    }

    @Override
    public void validate() {
        if (amount % LottoConstants.LOTTO_PURCHASE_AMOUNT != 0) {
            throw new InvalidLottoNumberException(INVALID_AMOUNT_MESSAGE);
        }
    }
}
