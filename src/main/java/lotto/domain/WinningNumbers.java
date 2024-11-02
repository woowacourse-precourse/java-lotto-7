package lotto.domain;

import java.util.List;

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

    public static WinningNumbers from(List<Integer> winningNumber, Integer bonusNumber) {
        Lotto winningLotto = new Lotto(winningNumber);
        return new WinningNumbers(winningLotto, bonusNumber);
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber < MIN_NUMBER.getNumber() || bonusNumber > MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber()));
        }
    }

    private void validateDuplicatedNumber(Lotto winningLotto, Integer bonusNumber) {
        if (winningLotto.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }
}
