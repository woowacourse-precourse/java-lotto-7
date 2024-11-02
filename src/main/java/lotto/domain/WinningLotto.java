package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new Lotto(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto userLotto) {
        return winningLotto.countMatchingNumbers(userLotto);
    }

    public boolean isBonusNumberMatched(Lotto userLotto) {
        return userLotto.containsNumber(bonusNumber);
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
