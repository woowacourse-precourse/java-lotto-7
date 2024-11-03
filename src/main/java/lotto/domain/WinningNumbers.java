package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    private void validateBonusNumber() {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < LottoConstants.LOTTO_MIN_NUMBER || bonusNumber > LottoConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
