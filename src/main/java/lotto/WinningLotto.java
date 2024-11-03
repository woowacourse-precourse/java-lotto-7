package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    private WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(new Lotto(numbers), bonusNumber);
    }

    public boolean isWinningNumber(int number) {
        return lotto.getNumbers().contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber == number;
    }
}
