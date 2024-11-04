package lotto.domain;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45인 정수여야 합니다.");
        }
    }

    public void validateExistLottoNumber(Lotto lotto) {
        for (int number : lotto.getNumbers()) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않은 수여야 합니다.");
            }
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
