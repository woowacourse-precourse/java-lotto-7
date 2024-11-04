package lotto.winning;

import java.util.List;
import java.util.Objects;
import lotto.core.LottoNumber;

public class BonusNumber {

    private final LottoNumber bonus;

    public BonusNumber(String input, WinningNumbers winningNumbers) {
        LottoNumber bonus = LottoNumber.toLottoNumber(input);
        winningNumbers.checkDuplicate(bonus);
        this.bonus = bonus;
    }

    public boolean contained(List<LottoNumber> numbers) {
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
