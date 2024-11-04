package lotto.domain;

import java.util.List;
import lotto.global.message.ErrorMessage;

public class WinningNumbers {
    private final Lotto mainNumbers;
    private final BonusNumber bonusNumber;

    private WinningNumbers(Lotto mainNumbers, BonusNumber bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(Lotto mainNumbers, BonusNumber bonusNumber) {
        validate(mainNumbers, bonusNumber);
        return new WinningNumbers(mainNumbers, bonusNumber);
    }

    private static void validate(Lotto mainNumbers, BonusNumber bonusNumber) {
        validateBonusNumberDuplicate(mainNumbers, bonusNumber);
    }

    private static void validateBonusNumberDuplicate(Lotto mainNumbers, BonusNumber bonusNumber) {
        if (mainNumbers.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER);
        }
    }

    public int countMatchNumbers(Lotto lotto) {
        int matchCount = 0;
        List<Integer> numbers = lotto.getNumbers();

        for (Integer number : numbers) {
            matchCount += countMatchNumber(number);
        }
        return matchCount;
    }

    private int countMatchNumber(Integer number) {
        if (mainNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(bonusNumber.getNumber());
    }
}
