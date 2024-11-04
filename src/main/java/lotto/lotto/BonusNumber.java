package lotto.lotto;

import static lotto.lotto.constant.LottoConstant.MAXIMUM_LOTTO_VALUE;
import static lotto.lotto.constant.LottoConstant.MINIMUM_LOTTO_VALUE;

import java.util.Objects;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        validateNumbersInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BonusNumber that)) {
            return false;
        }
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumbersInRange(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_VALUE || bonusNumber > MAXIMUM_LOTTO_VALUE) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 정수여야 합니다.");
        }
    }

    private void validateDuplicated(int bonusNumber) {

    }
}
