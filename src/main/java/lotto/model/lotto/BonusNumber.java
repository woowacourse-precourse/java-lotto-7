package lotto.model.lotto;

import view.exception.LottoException;

public record BonusNumber(int bonusNumber) {
    private static final String LOTTO_RANGE_ERROR = "보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.";

    public BonusNumber {
        validateBonusNumber(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoConstants.LOTTO_NUM_MIN || bonusNumber > LottoConstants.LOTTO_NUM_MAX) {
            throw new LottoException(LOTTO_RANGE_ERROR);
        }
    }
}
