package lotto.domain;

public class WinningLotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateDuplicatedBonusNumber(winningLotto, bonusNumber);
        validateNBonusNumberRange(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicatedBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    private void validateNBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + MIN_NUMBER + "에서 " + MAX_NUMBER + " 사이여야 합니다.");
        }
    }

    public Rank getLottoRank(Lotto issuedLotto) {
        int matchingNumber = winningLotto.getMatchingCount(issuedLotto);
        boolean hasBonusNumber = issuedLotto.isContainNumber(bonusNumber);
        return Rank.getWinnerPrize(matchingNumber, hasBonusNumber);
    }
}
