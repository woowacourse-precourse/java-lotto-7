package lotto.domain;

import java.util.List;
import lotto.constant.LottoConstant;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        if (bonusNumber < LottoConstant.LOTTO_NUMBER_MIN_RANGE || bonusNumber > LottoConstant.LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 올바른 범위의 숫자를 입력하지 않았습니다.");
        }
    }

    public boolean isSameAsAny(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
