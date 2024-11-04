package lotto.model;

import static lotto.common.constants.ExceptionMessages.ERROR_BONUS_NUMBER_SAME;

import java.util.List;
import java.util.Objects;

public class WinningNumbers {
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningNumbers(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public List<Integer> getWinLottoNumbers() {
        return lotto.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonus.getNumber();
    }

    private void validate(Lotto lotto, Bonus bonus) {
        for (Integer number : lotto.getNumbers()) {
            if (Objects.equals(number, bonus.getNumber())) {
                throw new IllegalArgumentException(ERROR_BONUS_NUMBER_SAME.getMessage());
            }
        }
    }
}
