package lotto.Model;

import lotto.Constants;

public class LottoAmountValidator {
    public final String amountOfLottoBeforeValidate;
    public int parsedAmountOfLotto;
    public int lottoAmount;

    public LottoAmountValidator(String amountOfLottoBeforeValidate) {
        this.amountOfLottoBeforeValidate = amountOfLottoBeforeValidate;
        validate();
    }

    private void validate() {
        validateBlank();
        validateContainsString();
        validateThousandUnit();
    }

    private void validateBlank() {
        if (this.amountOfLottoBeforeValidate.isBlank() || this.amountOfLottoBeforeValidate.isEmpty()) {
            System.out.println(Constants.LOTTO_AMOUNT_BLANK_ERROR);
            throw new IllegalArgumentException(Constants.LOTTO_AMOUNT_BLANK_ERROR);
        }
    }

    private void validateContainsString() {
        try {
            this.parsedAmountOfLotto = Integer.parseInt(this.amountOfLottoBeforeValidate);
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.LOTTO_AMOUNT_CONTAINS_STRING_ERROR);
            throw new IllegalArgumentException(Constants.LOTTO_AMOUNT_CONTAINS_STRING_ERROR);
        }
    }

    private void validateThousandUnit() {
        if (this.parsedAmountOfLotto % 1000 != 0) {
            System.out.println(Constants.LOTTO_AMOUNT_UNIT_ERROR);
            throw new IllegalArgumentException(Constants.LOTTO_AMOUNT_UNIT_ERROR);
        }
        this.lottoAmount = this.parsedAmountOfLotto / 1000;
    }
}
