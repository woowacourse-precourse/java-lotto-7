package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Lotto other, int bonusNumber) {
        int equalNumbersCount = lotto.getEqualNumbersCount(other);
        if (equalNumbersCount == 6) {
            return new Rank(1);
        }
        if (equalNumbersCount == 5) {
            if (this.bonusNumber == bonusNumber) {
                return new Rank(2);
            }
            return new Rank(3);
        }
        if (equalNumbersCount < 3) {
            return new Rank(-1);
        }
        return new Rank(8 - equalNumbersCount);
    }
}
