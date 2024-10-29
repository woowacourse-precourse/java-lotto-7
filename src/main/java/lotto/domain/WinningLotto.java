package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateDuplicatedBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicatedBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public Rank getLottoRank(Lotto issuedLotto) {
        int matchingNumber = countMatchingNumber(issuedLotto);
        boolean hasBonusNumber = issuedLotto.isContainNumber(bonusNumber);
        return Rank.getWinnerPrize(matchingNumber, hasBonusNumber);
    }

    private int countMatchingNumber(Lotto issuedLotto) {
        return (int) issuedLotto.toDto()
                .getNumbers()
                .stream()
                .filter(lotto::isContainNumber)
                .count();
    }
}
