package lotto.model;

import lotto.constant.LottoConstant;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberRange(String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        if (bonusNumber < LottoConstant.LOTTO_NUMBER_LOWER_BOUND.getNumber() || bonusNumber > LottoConstant.LOTTO_NUMBER_UPPER_BOUND.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자의 범위가 1~45를 벗어납니다.");
        }
    }
}
