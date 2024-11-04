package lotto.model.vo;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoInfo;
import lotto.exception.ErrorStatus;
import lotto.exception.handler.WinningNumberErrorHandler;
import lotto.model.domain.Lotto;

public class WinningNumber {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateUnique(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int numbers) {
        if (numbers < LottoInfo.LOTTO_MIN_LIMIT.getValue()
                || numbers > LottoInfo.LOTTO_MAX_LIMIT.getValue()) {
            throw new WinningNumberErrorHandler(ErrorStatus.BONUS_NUMBER_OUT_RANGE_ERROR);
        }
    }

    private void validateUnique(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().stream()
                .anyMatch(num -> num == bonusNumber)) {
            throw new WinningNumberErrorHandler(ErrorStatus.BONUS_NUMBER_UNIQUE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(lotto.getNumbers());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
