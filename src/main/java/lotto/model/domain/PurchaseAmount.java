package lotto.model.domain;

import static lotto.constant.LottoConstant.AMOUNT_UNIT;
import static lotto.constant.LottoConstant.MAX_AMOUNT;
import static lotto.ui.error.InputError.MAX_AMOUNT_ERR;
import static lotto.ui.error.InputError.MIN_AMOUNT_ERR;
import static lotto.ui.error.InputError.PURCHASE_AMOUNT_UNIT_ERR;

public class PurchaseAmount {
    private int amount;

    public PurchaseAmount(int amount) {
        validateMinAmount(amount);
        validateMaxAmount(amount);
        validateAmountUnit(amount);
        this.amount = amount;
    }

    public int get() {
        return amount;
    }

    public int getLottoCount() {
        return amount / AMOUNT_UNIT;
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

    private void validateAmountUnit(Integer amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERR);
        }
    }


}
