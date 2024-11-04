package lotto.model;

import lotto.policy.PrizeMoneyPolicy;

public class Winning {
    private final Lotto winningLotto;
    private final Bonus bonus;

    public Winning(Lotto winningLotto, Bonus bonus) {
        validateBonusInWinningLotto(winningLotto, bonus);
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    private void validateBonusInWinningLotto(Lotto winningLotto, Bonus bonus) {
        if (winningLotto.getNumbers().contains(bonus.getBonusNumber())) {
            throw new IllegalArgumentException("보너스 번호가 당첨 로또 번호와 중복됩니다.");
        }
    }

    public int match(Lotto lotto) {
        long matchCount = lotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
        return (int) matchCount;
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.getNumbers().stream()
                .anyMatch(bonus::isMatch);
    }

    public PrizeMoneyPolicy getRank(Lotto lotto) {
        int matchCount = match(lotto);
        boolean bonusMatch = isBonusMatch(lotto);

        return PrizeMoneyPolicy.getRank(matchCount, bonusMatch);
    }
}
