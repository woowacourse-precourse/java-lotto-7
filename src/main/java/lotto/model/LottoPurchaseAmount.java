package lotto.model;

import lotto.view.constant.ErrorConstant;
import lotto.view.constant.ValidatorConstant;

public class LottoPurchaseAmount {
    private final int AMOUNT_UNIT = 1000;
    private final int amount;

    public LottoPurchaseAmount(String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(String amount) {
        if (!amount.isEmpty())
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_ENTERED);
        if (!ValidatorConstant.NUMBER_PATTERN.matcher(amount).matches())
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_NUMBER);
        if (Integer.parseInt(amount) == 0)
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_POSITIVE);
        if (Integer.parseInt(amount) % AMOUNT_UNIT != 0)
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_MULTIPLE_OF_THOUSAND);
    }
}
