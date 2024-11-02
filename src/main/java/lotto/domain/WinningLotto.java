package lotto.domain;

import java.util.List;
import lotto.exception.ErrorCode;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw ErrorCode.DUPLICATE_BONUS_NUMBER.throwError();
        }
    }

    public int matchNumbers(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean matchBonus(Lotto userLotto) {
        return userLotto.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}