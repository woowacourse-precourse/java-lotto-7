package lotto.domain;

import java.util.List;
import lotto.util.NumberValidator;

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
        final NumberValidator<Integer> numberValidator = NumberValidator.getInstance();
        numberValidator.validateContains(numbers, value);
    }

    public LottoRank matchWithLotto(final Lotto lotto) {
        final int matchCount = countMatchNumber(lotto);
        final boolean matchBonusNumber = isMatchBonusNumber(lotto);
        return LottoRank.findByMatchCountAndMatchBonus(matchCount, matchBonusNumber);
    }

    private boolean isMatchBonusNumber(final Lotto lotto) {
        return bonusNumber.isMatchNumber(lotto);
    }

    private int countMatchNumber(final Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto::isContainsNumber)
                .count();
    }

}
