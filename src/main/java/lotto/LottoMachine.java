package lotto;

import java.util.List;

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

    public List<WinningType> checkWinnings(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::checkWinning)
                .filter(winningType -> isWinning(winningType))
                .toList();
    }

    private boolean isWinning(WinningType winningType) {
        if (winningType.getSameCount() == -1) {
            return false;
        }
        return true;
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }

}
