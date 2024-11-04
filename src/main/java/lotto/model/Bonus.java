package lotto.model;

import lotto.policy.LottoNumberPolicy;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatch(int number) {
        return this.bonusNumber == number;
    }

    private void validateBonusNumber(int bonusNumber) {
        int min = LottoNumberPolicy.MIN_NUMBER.number();
        int max = LottoNumberPolicy.MAX_NUMBER.number();
        if (bonusNumber < min || bonusNumber > max) {
            throw new IllegalArgumentException("[ERROR] 입력 가능한 보너스 번호의 범위는 1 ~ 45 입니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
