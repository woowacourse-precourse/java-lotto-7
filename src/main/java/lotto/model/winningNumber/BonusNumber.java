package lotto.model.winningNumber;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
