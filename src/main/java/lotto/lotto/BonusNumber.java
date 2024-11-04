package lotto.lotto;

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
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 정수여야 합니다.");
        }
    }
}
