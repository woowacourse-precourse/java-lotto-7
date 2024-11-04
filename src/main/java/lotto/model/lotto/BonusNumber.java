package lotto.model.lotto;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber, Lotto lotto) {
        validateBonusNumber(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber, Lotto lotto) {
        return new BonusNumber(bonusNumber, lotto);
    }

    private void validateBonusNumber(int bonusNumber, Lotto lotto) {

        isBonusNumberNegative(bonusNumber);

        isBonusNumberInRange(bonusNumber);

        isBonusNumberNotDuplicated(bonusNumber, lotto);
    }

    private void isBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < LottoRange.MIN_NUMBER.getDescription()
                || bonusNumber > LottoRange.MAX_NUMBER.getDescription()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해주세요.");
        }
    }

    private void isBonusNumberNegative(int bonusNumber) {
        if (bonusNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 음수를 입력할 수 없습니다.");
        }
    }

    private void isBonusNumberNotDuplicated(int bonusNumber, Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
