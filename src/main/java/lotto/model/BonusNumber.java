package lotto.model;

import static lotto.model.LottoRule.MAX_NUMBER;
import static lotto.model.LottoRule.MIN_NUMBER;

import lotto.dto.BonusNumberRequestDTO;

public class BonusNumber {
    private static final String OVER_RANGE_MESSAGE = "[ERROR] 보너스 번호의 범위를 초과했습니다.";

    private int bonusNumber;

    public BonusNumber(BonusNumberRequestDTO request) {
        validate(request.getBonusNumber());
        this.bonusNumber = request.getBonusNumber();
    }

    private void validate(int bonusNumber) {
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER.getConstant() || MAX_NUMBER.getConstant() < bonusNumber) {
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
    }

    public boolean isBonusNumber(Integer number) {
        return bonusNumber == number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
