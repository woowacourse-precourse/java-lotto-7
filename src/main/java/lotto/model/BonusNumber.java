package lotto.model;

import lotto.util.Validator;

public record BonusNumber(int bonusNumber) {

    public void validate(Lotto winningNumbers) {
        Validator.validateIsDuplicate(winningNumbers, bonusNumber);
        Validator.validateLottoRange(bonusNumber);
    }
}
