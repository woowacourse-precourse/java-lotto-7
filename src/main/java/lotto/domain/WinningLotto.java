package lotto.domain;

import static lotto.domain.LottoConstants.IS_DUPLICATE_NUMBER;
import static lotto.domain.LottoConstants.IS_NOT_LOTTO_NUMBER;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(bonusNumber, winningLotto);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < LottoConstants.LOTTO_MIN_NUM || bonusNumber > LottoConstants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_NUMBER);
        }
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
