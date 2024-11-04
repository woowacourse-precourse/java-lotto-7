package lotto.domain;

import java.util.Optional;
import lotto.domain.validator.ParamsValidator;
import lotto.exception.winningLotto.BonusNumberDuplicatedException;

final public class WinningLotto {

    private final Lotto winningNumbers;
    private final Number bonusNumber;

    private WinningLotto(Lotto winningNumbers, Number bonusNumber) {
        validateBonusNumberNotDuplicated(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumberNotDuplicated(Lotto winningNumbers, Number bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberDuplicatedException();
        }
    }

    public static WinningLotto of(Lotto winningNumbers, Integer bonusNumber) {
        ParamsValidator.validateParamsNotNull(WinningLotto.class, winningNumbers, bonusNumber);

        return new WinningLotto(winningNumbers, Number.from(bonusNumber));
    }

    public Optional<LottoPrize> matchLotto(Lotto targetLotto) {
        ParamsValidator.validateParamsNotNull(WinningLotto.class, targetLotto);

        int numberMatch = targetLotto.getMatchCount(winningNumbers);
        boolean bonusNumberMatch = targetLotto.contains(bonusNumber);

        return LottoPrize.calculatePrize(numberMatch, bonusNumberMatch);
    }
}
