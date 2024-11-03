package lotto.winning;

import constants.ErrorMessage;
import java.util.List;
import java.util.Objects;
import lotto.LottoNumber;

public class BonusNumber {

    private final LottoNumber bonus;

    public BonusNumber(String input, WinningNumbers winningNumbers) {
        LottoNumber bonus = toLottoNumber(input);
        winningNumbers.checkDuplicate(bonus);
        this.bonus = bonus;
    }

    private LottoNumber toLottoNumber(String textNumber) {
        try {
            return LottoNumber.from(Integer.parseInt(textNumber));
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.ENTERED_INVALID_NUMBER);
        }
    }

    public boolean contains(List<LottoNumber> numbers) {
        return numbers.contains(bonus);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof BonusNumber that)) {
            return false;
        }
        return Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonus);
    }
}
