package lotto;

import static lotto.ExceptionMessages.ERROR_BONUS_NUMBER_SAME;
import static lotto.ExceptionMessages.ERROR_LOTTO_NUMBER_RANGE;

import java.util.List;
import java.util.Objects;

public class WinningNumbers {
    private final Lotto lotto;
    private final Integer bonus;

    public WinningNumbers(Lotto lotto, Integer bonus) {
        validate(lotto, bonus);
        validate(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public void validate(Lotto lotto, Integer bonus) {
        for (Integer number : lotto.getNumbers()) {
            if (Objects.equals(number, bonus)) {
                throw new IllegalArgumentException(ERROR_BONUS_NUMBER_SAME.getMessage());
            }
        }
    }

    public void validate(Integer bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getWinLottoNumbers() {
        return lotto.getNumbers();
    }

    public Integer getBonus() {
        return bonus;
    }
}
