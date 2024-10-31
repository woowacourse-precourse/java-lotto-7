package lotto.validator;

import static lotto.util.LottoUtils.validateNumberRange;

public class BonusNumberValidator implements Validator<Integer> {

    @Override
    public void validate(Integer bonusNumber) {
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        validateNumberRange(bonusNumber);
    }
}
