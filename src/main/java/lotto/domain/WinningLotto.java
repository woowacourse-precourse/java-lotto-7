package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new LottoException("[ERROR] 보너스 번호는 1 이상 45 이하의 숫자여야 합니다.");
        }
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new LottoException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinningLotto that = (WinningLotto) o;

        if (bonusNumber != that.bonusNumber) return false;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        int result = winningNumbers != null ? winningNumbers.hashCode() : 0;
        result = 31 * result + bonusNumber;
        return result;
    }
}
