package lotto;

public class BonusNumber {
    private static int BONUS_NUMBER;

    public BonusNumber(int bonusNumber) {
        this.BONUS_NUMBER = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이어야 합니다.");
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
