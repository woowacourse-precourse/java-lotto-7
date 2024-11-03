package lotto.service;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        isRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void isRange(int input) {
        if (!(1 <= input && input <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 수만 입력해주세요.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
