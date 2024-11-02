package lotto.view.input;

import static lotto.model.domain.LottoConstant.*;
import static lotto.view.input.InputError.*;

public class InputValidator {

    public void validateAmount(Integer amount) {
        validateAmountUnit(amount);
        validateMaxAmount(amount);
        validateMinAmount(amount);
    }

    private void validateAmountUnit(Integer amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERR);
        }
    }

    private void validateMaxAmount(Integer amount) {
        if (amount > MAX_AMOUNT) {
            throw new IllegalArgumentException(MAX_AMOUNT_ERR);
        }
    }

    private void validateMinAmount(Integer amount) {
        if (amount < AMOUNT_UNIT) {
            throw new IllegalArgumentException(MIN_AMOUNT_ERR);
        }
    }






}
