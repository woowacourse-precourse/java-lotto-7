package lotto.domain;

public class BonusNumber {
    private static int BONUS_NUMBER;

    public BonusNumber(int bonusNumber, Lotto winningLotto) {
        validate(bonusNumber, winningLotto);
        this.BONUS_NUMBER = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이어야 합니다.");
        }
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹치면 안됩니다.");
        }
    }

    public static boolean isMatchedBonusNumber(Lotto lotto) {
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (BONUS_NUMBER == lottoNumber) {
                return true;
            }
        }
        return false;
    }
}
