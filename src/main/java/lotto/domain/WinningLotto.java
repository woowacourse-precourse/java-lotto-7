package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateDuplicatedBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicatedBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public Rank getLottoRank(Lotto issuedLotto) {
        int matchingNumber = winningLotto.getMatchingCount(issuedLotto);
        boolean hasBonusNumber = issuedLotto.isContainNumber(bonusNumber);
        return Rank.getWinnerPrize(matchingNumber, hasBonusNumber);
    }
}
