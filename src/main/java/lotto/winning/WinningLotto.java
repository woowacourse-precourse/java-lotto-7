package lotto.winning;

import java.util.List;
import java.util.Objects;
import lotto.core.LottoNumber;

public class WinningLotto {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countWinnings(List<LottoNumber> numbers) {
        return winningNumbers.countNumbers(numbers);
    }

    public boolean containsBonus(List<LottoNumber> numbers) {
        return bonusNumber.contained(numbers);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WinningLotto winningLotto)) {
            return false;
        }
        return bonusNumber == winningLotto.bonusNumber && Objects.equals(winningNumbers, winningLotto.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
