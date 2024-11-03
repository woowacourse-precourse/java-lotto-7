package lotto.domain.input;

import lotto.config.validation.FieldValidation;
import lotto.config.validation.annotation.Divisible;
import lotto.config.validation.annotation.Min;

public class PurchaseAmount extends FieldValidation {

    @Min(1_000)
    @Divisible(value = 1_000, message = "구입 금액은 1,000원 단위여야 합니다.")
    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;

        super.valid();
    }

    public int getAmount() {
        return amount;
    }
}
