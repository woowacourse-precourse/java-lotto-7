package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoGameIllegalArgumentException;

public class Validator {
    public static void validateAmountInput(String amountInput) {
        if (!amountInput.matches("\\d+")) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_TYPE);
        }

        if (Integer.parseInt(amountInput) % 1000 > 0) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_LOTTO_PRICE_UNIT);
        }
    }

    public static void validateWinningLottoInput(String[] winningLottoInput) {
        if (winningLottoInput.length != 6) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
    }

    public static void validateWinningLotto(List<Integer> winningLotto) {
        for (int lottoNumber : winningLotto) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    public static List<Integer> convertWinningLottoInputToIntArray(String[] winningLottoInput) {
        List<Integer> winningLotto = new ArrayList<>();
        try {
            for (String eachWinningLottoNumber : winningLottoInput) {
                winningLotto.add(Integer.parseInt(eachWinningLottoNumber.trim()));
            }
            return winningLotto;
        } catch (NumberFormatException e) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_TYPE);
        }
    }

    public static int validateBonusNumberInput(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_TYPE);
        }
    }
}
