package lotto.domain.number;

import java.util.List;
import lotto.domain.winning.LottoRank;
import lotto.util.NumberValidator;

public class Winning {

    private final Lotto winningLotto;
    private final Bonus bonus;

    public Winning(final Lotto winningLotto, final Bonus bonus) {
        validate(winningLotto, bonus);
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    private void validate(final Lotto winningLotto, final Bonus bonus) {
        final List<Integer> numbers = winningLotto.getNumbers();
        final int value = bonus.getValue();
        final NumberValidator<Integer> numberValidator = NumberValidator.getInstance();
        numberValidator.validateContains(numbers, value);
    }

    public LottoRank matchWithLotto(final Lotto lotto) {
        final int matchCount = countMatchNumber(lotto);
        final boolean matchBonusNumber = isMatchBonusNumber(lotto);
        return LottoRank.findByMatchCountAndMatchBonus(matchCount, matchBonusNumber);
    }

    private boolean isMatchBonusNumber(final Lotto lotto) {
        return bonus.isMatchNumber(lotto);
    }

    private int countMatchNumber(final Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto::isContainsNumber)
                .count();
    }

}
