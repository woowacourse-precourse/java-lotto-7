package lotto.util;

import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoGameIllegalArgumentException;

public class Validator {
    public static void validateAmountInput(String amountInput) {
        if (!amountInput.matches("\\d+")) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_TYPE);
        }

        int purchaseAmount = Integer.parseInt(amountInput);
        if (purchaseAmount <= 0 || purchaseAmount % 1000 > 0) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_LOTTO_PURCHASE_AMOUNT);
        }
    }

    public static void validateWinningLottoInputLength(String[] winningLottoInput) {
        if (winningLottoInput.length != 6) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
    }

    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }

        Set<Integer> distinctLottoNumbers = Set.copyOf(lottoNumbers);
        if (distinctLottoNumbers.size() != 6) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_REPETITION);
        }
    }

    public static void validateWinningLottoRange(List<Integer> winningLotto) {
        for (int lottoNumber : winningLotto) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    public static void validateBonusNumberInput(String bonusNumberInput) {
        if (!bonusNumberInput.matches("\\d+")) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_TYPE);
        }

        if (Integer.parseInt(bonusNumberInput) < 1 || Integer.parseInt(bonusNumberInput) > 45) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
    }
}
