package lotto.parser;

import static lotto.config.constant.ExceptionMessageConstant.INVALID_LOTTO_NUMBER_FORMAT;
import static lotto.config.constant.ExceptionMessageConstant.INVALID_LOTTO_PURCHASE_AMOUNT_FORMAT;
import static lotto.config.constant.ExceptionMessageConstant.INVALID_LOTTO_PURCHASE_AMOUNT_UNIT;

import java.util.ArrayList;
import java.util.List;
import lotto.config.constant.LottoPurchaseConstant;

public class UserInputParser {

    public final String LOTTO_NUMBER_SEPARATOR = ",";

    public long getLottoPurchaseAmount(String lottoPurchaseAmountInput) {
        try {
            long lottoPurchaseAmount = Long.parseLong(lottoPurchaseAmountInput);
            validateLottoPurchaseAmountInput(lottoPurchaseAmount);

            return lottoPurchaseAmount;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_AMOUNT_FORMAT);
        }
    }


    public List<Integer> getLottoWinningNumbers(String lottoWinningNumbersInput) {

        try {
            String[] numbersSplit = lottoWinningNumbersInput.split(LOTTO_NUMBER_SEPARATOR);
            List<Integer> winningNumbers = new ArrayList<>();
            for (String numberInput : numbersSplit) {
                winningNumbers.add(Integer.parseInt(numberInput));
            }
            return winningNumbers;

        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT);
        }

    }

    public int getLottoWinningBonusNumber(String winningBonusNumberInput) {
        try {
            return Integer.parseInt(winningBonusNumberInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT);
        }
    }

    private void validateLottoPurchaseAmountInput(long lottoPurchaseAmount) {
        if (lottoPurchaseAmount % LottoPurchaseConstant.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_AMOUNT_UNIT);
        }
    }

}
