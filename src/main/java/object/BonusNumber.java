package object;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        rangeValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void rangeValidate(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1-45 사이의 숫자여야 합니다.");
        }
    }
}
