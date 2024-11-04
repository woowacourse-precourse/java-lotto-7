package lotto.domain;

import static lotto.common.ExceptionMessage.NO_OVERLAP_NUMBER;

import java.util.List;

public class WinLotto {

    private Lotto lotto;
    private int bonusNumber;

    private WinLotto(Lotto lotto, int bonusNumber) {
        validateNoOverlap(lotto.getNumbers(), bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static WinLotto of(Lotto lotto, int bonusNumber) {
        return new WinLotto(lotto, bonusNumber);
    }

    private void validateNoOverlap(List<Integer> numbers, int bonusNumber) {
        boolean isOverlap = numbers.stream()
                .anyMatch(number -> number == bonusNumber);

        if (isOverlap) {
            throw new IllegalArgumentException(NO_OVERLAP_NUMBER);
        }
    }
}
