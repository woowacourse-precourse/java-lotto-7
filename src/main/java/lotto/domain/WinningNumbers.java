package lotto.domain;

import static lotto.domain.constant.LottoRule.MAX_NUMBER;
import static lotto.domain.constant.LottoRule.MIN_NUMBER;
import static lotto.exception.ExceptionMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.NUMBER_OUT_OF_RANGE;

public class WinningNumbers {

    private final Lotto winningLotto;
    private final Integer bonusNumber;

    private WinningNumbers(Lotto winningLotto, Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateDuplicatedNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers from(Lotto winningLotto, Integer bonusNumber) {
        return new WinningNumbers(winningLotto, bonusNumber);
    }

    public int getMatchingCount(Lotto lotto) {
        return lotto.getMatchingCount(winningLotto);
    }

    public boolean hasMatchingBonusNumber(Lotto lotto) {
        return lotto.hasBonusNumber(bonusNumber);
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber < MIN_NUMBER.getNumber() || bonusNumber > MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateDuplicatedNumber(Lotto winningLotto, Integer bonusNumber) {
        if (winningLotto.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }
}
