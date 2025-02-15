package lotto.validator;

import static lotto.constant.ErrorCode.DUPLICATE_BONNUS_NUMBER;

import lotto.domain.Lotto;

public class BonusNumberValidator {

    private final RangeValidator rangeValidator;

    public BonusNumberValidator(final RangeValidator rangeValidator) {
        this.rangeValidator = rangeValidator;
    }

    public void validate(final int bonusNumber, final Lotto lotto) {
        rangeValidator.validateNumberRange(bonusNumber);
        validateBonusNumberInLottoNumbers(bonusNumber, lotto);
    }

    private void validateBonusNumberInLottoNumbers(final int bonusNumber, final Lotto lotto) {
        if (lotto.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONNUS_NUMBER.getMessage());
        }
    }

}
