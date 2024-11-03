package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
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
