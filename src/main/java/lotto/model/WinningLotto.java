package lotto.model;

public class WinningLotto {

    private Lotto lotto;
    private Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;

        LottoNumberValidator.validateNumberRange(bonusNumber);
    }

    public Prize getPrize(Lotto otherLotto) {
        Integer winningCount = otherLotto.countWinningNumbers(lotto);
        boolean bonusNumberMatched = otherLotto.isBonusNumberMatch(bonusNumber);

        return Prize.calculatePrize(winningCount, bonusNumberMatched);
    }
}
