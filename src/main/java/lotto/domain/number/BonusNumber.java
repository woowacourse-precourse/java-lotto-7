package lotto.domain.number;

import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(final int input) {
        this.bonusNumber = input;
    }

    public static BonusNumber from(final int input) {
        return new BonusNumber(input);
    }

    public boolean contains(final List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}