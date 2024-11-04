package lotto;

public class LottoMachine {

    private Lotto winningLotto;
    private int bonusNumber;
    private WinningTypes winningTypes;

    public LottoMachine(Lotto winningLotto, int bonusNumber, WinningTypes winningTypes) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.winningTypes = winningTypes;
    }

    public WinningType checkWinning(Lotto lotto) {
        int count = winningLotto.calculateEqualCount(lotto);
        WinningType winningType = winningTypes.getWinning(count);
        if (hasBonusNumber(lotto) && count == 5) {
            winningType = winningTypes.getBonusWinning();
        }
        return winningType;
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }

}
