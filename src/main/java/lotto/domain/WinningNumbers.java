package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbersSize(winningNumbers);
        this.winningLotto = new Lotto(winningNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < LottoConstants.LOTTO_MIN_NUMBER || bonusNumber > LottoConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }
}
