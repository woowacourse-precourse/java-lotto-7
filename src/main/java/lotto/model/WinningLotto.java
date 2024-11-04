package lotto.model;

public class WinningLotto {

    private static final String ERROR_DUPLICATE_BONUS_NUMBER = "[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.";

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS_NUMBER);
        }
    }

    public int countMatchedLottoNumber(Lotto purchasedLotto) {
        return (int) purchasedLotto.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    public boolean isMatchBonusNumber(Lotto purchasedLotto) {
        return purchasedLotto.getNumbers().contains(bonusNumber.getNumber());
    }
}
