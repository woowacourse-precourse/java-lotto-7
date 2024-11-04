package lotto.validation;

import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionCode;

public class LottoContextValidator {
    public static void validateWinningNumbers(List<Integer> winningNumber) throws LottoException {
        if (winningNumber.size() != 6) {
            throw new LottoException(LottoExceptionCode.NOT_VALID_NUMBER_OF_WINNING_NUMBER);
        }
        List<Integer> distinctList = winningNumber.stream().distinct().toList();
        if (distinctList.size() != winningNumber.size()) {
            throw new LottoException(LottoExceptionCode.DUPLICATED_WINNING_NUMBERS);
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumber) throws LottoException {
        if (winningNumber.contains(bonusNumber)) {
            throw new LottoException(LottoExceptionCode.DUPLICATED_BONUS_NUMBER);
        }
    }
}
