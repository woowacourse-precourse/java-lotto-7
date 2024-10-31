package lotto;

import java.util.List;

public class WinningNumbers {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(final Lotto winningLotto, final BonusNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final Lotto winningLotto, final BonusNumber bonusNumber) {
        final List<Integer> numbers = winningLotto.getNumbers();
        final int value = bonusNumber.getValue();
        final LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
        lottoNumberValidator.validateContains(numbers, value);
    }

    public int countMatchNumber(final List<Integer> numbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningLotto.isContainsNumber(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isMatchBonusNumber(final List<Integer> numbers) {
        return bonusNumber.isMatchNumber(numbers);
    }
}
