package lotto.model;

import java.util.List;
import lotto.enums.LottoEnum;
import lotto.utils.Utils;
import lotto.enums.ErrorMessage;
import java.math.BigDecimal;

public class WinningNumber extends Lotto {
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateWinningNumber(numbers);
        validateBonusNumber(BigDecimal.valueOf(bonusNumber));
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumber(List<Integer> numbers) {

    }

    private void validateBonusNumber(BigDecimal bonusNumber) {
        if (!Utils.isInRange(new BigDecimal(LottoEnum.MIN_LOTTO_RANGE.getRange()),
                new BigDecimal(LottoEnum.MAX_LOTTO_RANGE.getRange()), bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }

    public int getWinningRank(Lotto oneLotto) {
        List<Integer> winningNumber = this.getNumbers();
        int matchedCount = 0;
        boolean matchedBonusNumber = false;

        for (Integer singleNumber : winningNumber) {
            if (oneLotto.getNumbers().contains(singleNumber)) {
                matchedCount++;
            }
        }
        if (oneLotto.getNumbers().contains(bonusNumber)) {
            matchedBonusNumber = true;
        }

        if (matchedCount >= 0 && matchedCount <= 2) {
            return 0;
        }
        if (matchedCount == 3) {
            return 5;
        }
        if (matchedCount == 4) {
            return 4;
        }
        if (matchedCount == 5 && !matchedBonusNumber) {
            return 3;
        }
        if (matchedCount == 5 && matchedBonusNumber) {
            return 2;
        }
        return 1;
    }
}
