package lotto;

import java.util.List;

public class LottoDrawingMachine {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoDrawingMachine(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateRange(bonusNumber);
        validateBonusNumberUnique(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningStatics matchWinningLotto(List<Lotto> purChasedLotto) {
        WinningStatics winningStatics = new WinningStatics();
        for (Lotto lotto : purChasedLotto) {
            MatchResult result = this.winningLotto.match(lotto, this.bonusNumber);
            winningStatics.recordMatch(result);
        }
        return winningStatics;
    }

    private void validateRange(int input) {
        boolean isInvalid = input < Lotto.LOTTO_MINIMUM_NUMBER || input > Lotto.LOTTO_MAXIMUM_NUMBER;
        if (isInvalid) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
    }

    private void validateBonusNumberUnique(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹칠 수 없습니다.");
        }
    }
}
