package lotto.domain;

import java.util.List;

import static lotto.constants.LottoConstants.MIN_NUMBER;
import static lotto.constants.LottoConstants.MAX_NUMBER;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public boolean containsBonusNumber(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber);
    }

    private void validate(int bonusNumber) {
        validateBonusNumberInRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER.getValue() || bonusNumber > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumberDuplication(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
