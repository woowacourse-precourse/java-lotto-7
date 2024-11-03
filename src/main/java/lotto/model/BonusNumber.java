package lotto.model;

import java.util.List;
import lotto.constant.ErrorConstant;

public class BonusNumber {

    private final Integer number;

    private BonusNumber(final Integer number, final WinningNumbers winningNumbers) {
        validateNumber(number);
        validateDuplicatedNumber(number, winningNumbers);
        this.number = number;
    }

    public static BonusNumber create(final Integer number, final WinningNumbers winningNumbers) {
        return new BonusNumber(number, winningNumbers);
    }

    private void validateNumber(final Integer number) {
        if (number < Lotto.MINIMUM_THRESHOLD || number > Lotto.MAXIMUM_THRESHOLD) {
            throw new IllegalArgumentException(
                    ErrorConstant.ERROR.getContent() + " 당첨 번호는 " + Lotto.MINIMUM_THRESHOLD + "이상, " + Lotto.MAXIMUM_THRESHOLD
                            + "이하만 가능합니다.");
        }
    }

    private void validateDuplicatedNumber(final Integer number, final WinningNumbers winningNumbers) {
        final List<Integer> winnings = winningNumbers.getNumbers();
        if (winnings.contains(number)) {
            throw new IllegalArgumentException(
                    ErrorConstant.ERROR.getContent() + " 보너스 번호는 당첨 번호와 중복되어선 안됩니다."
            );
        }
    }

    public CorrectCount check(final List<Integer> lottoNumbers, final CorrectCount correctCount) {
        if (lottoNumbers.contains(number)) {
            correctCount.updateBonus();
        }
        return correctCount;
    }
}
