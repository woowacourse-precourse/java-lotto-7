package lotto.domain;

import java.util.List;
import lotto.global.message.ErrorMessage;

public class WinningNumbers {

    private final Lotto mainNumbers;
    private  BonusNumber bonusNumber;


    public WinningNumbers(Lotto winnerLotto, BonusNumber bonusNumber) {
        validate(winnerLotto, bonusNumber);
        this.mainNumbers = winnerLotto;
        this.bonusNumber = bonusNumber;
    }


    private void validate(Lotto mainNumbers, BonusNumber bonusNumber) {
        validateBonusNumberDuplicate(mainNumbers, bonusNumber);
    }

    private void validateBonusNumberDuplicate(Lotto mainNumbers, BonusNumber bonusNumber) {
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
