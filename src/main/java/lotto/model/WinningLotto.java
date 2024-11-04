package lotto.model;

public class WinningLotto {
    private final Lotto winningLottoNumbers;
    private final Bonus bonusNumber;

    public WinningLotto(Lotto winningLottoNumbers, Bonus bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLottoNumbers.getNumbers()::contains)
                .count();
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }
}
