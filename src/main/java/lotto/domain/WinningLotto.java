package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonus = new LottoNumber(bonusNumber);
        validateBonusNumberNotInWinningNumbers();
    }

    private void validateBonusNumberNotInWinningNumbers() {
        if (isBonusNumberInWinningNumbers()) {
            throw new IllegalArgumentException("당첨번호에 보너스번호가 존재 할 수 없습니다.");
        }
    }

    private boolean isBonusNumberInWinningNumbers() {
        return this.lotto.contains(this.bonus);
    }

    public Rank match(Lotto lotto) {
        return Rank.match(matchCount(lotto), hasBonus(lotto));
    }

    private int matchCount(Lotto lotto) {
        return this.lotto.matchCount(lotto);
    }

    private boolean hasBonus(Lotto lotto) {
        return lotto.contains(bonus);
    }
}
