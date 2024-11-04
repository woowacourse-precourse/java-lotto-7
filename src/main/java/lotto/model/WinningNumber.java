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
        validateBonusNumber(BigDecimal.valueOf(bonusNumber));
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(BigDecimal bonusNumber) {
        if (!Utils.isInRange(new BigDecimal(LottoEnum.MIN_LOTTO_RANGE.getNumber()),
                new BigDecimal(LottoEnum.MAX_LOTTO_RANGE.getNumber()), bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }

    public int getWinningRank(Lotto oneLotto) {
        int matchedCount;
        boolean isMatchedBonusNumber;

        matchedCount = countMatchingNumbers(oneLotto);
        isMatchedBonusNumber = isMatchBonusNum(oneLotto);

        return calculateWinningRank(matchedCount, isMatchedBonusNumber);
    }

    private int countMatchingNumbers(Lotto oneLotto) {
        int matchedCount = 0;

        for (Integer singleNumber : this.getNumbers()) {
            if (oneLotto.getNumbers().contains(singleNumber)) {
                matchedCount++;
            }
        }
        return matchedCount;
    }

    private boolean isMatchBonusNum(Lotto oneLotto) {
        if (oneLotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private int calculateWinningRank(int matchedCount, boolean isMatchedBonusNumber) {
        if (matchedCount >= 0 && matchedCount <= 2) {
            return 0;
        }
        if (matchedCount == 3) {
            return 5;
        }
        if (matchedCount == 4) {
            return 4;
        }
        if (matchedCount == 5 && !isMatchedBonusNumber) {
            return 3;
        }
        if (matchedCount == 5 && isMatchedBonusNumber) {
            return 2;
        }
        return 1;
    }
}