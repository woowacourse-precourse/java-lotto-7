package lotto.parser;

import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_NUMBER_FORMAT;
import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_PURCHASE_AMOUNT_FORMAT;
import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_PURCHASE_AMOUNT_UNIT;
import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_REQUIRED_COUNT;

import lotto.constant.LottoNumberConstant;
import lotto.constant.LottoPurchaseConstant;

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


    public int[] getLottoWinningNumbers(String lottoWinningNumbersInput) {

        try {
            String[] numbersSplit = lottoWinningNumbersInput.split(LOTTO_NUMBER_SEPARATOR);

            validateNumberOfWinningNumbers(numbersSplit.length);

            int[] winningNumbers = new int[LottoNumberConstant.REQUIRED_COUNT];

            for (int winningNumberId = 0; winningNumberId < winningNumbers.length; winningNumberId++) {
                winningNumbers[winningNumberId] = Integer.parseInt(numbersSplit[winningNumberId]);
                validateLottoNumber(winningNumbers[winningNumberId]);
            }

            return winningNumbers;

        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT);
        }

    }

    public int getLottoWinningBonusNumber(String winningBonusNumberInput) {
        try {
            int winningBonusNumber = Integer.parseInt(winningBonusNumberInput);
            validateLottoNumber(winningBonusNumber);

            return winningBonusNumber;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT);
        }
    }

    private void validateLottoPurchaseAmountInput(long lottoPurchaseAmount) {
        if (lottoPurchaseAmount % LottoPurchaseConstant.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_AMOUNT_UNIT);
        }
    }


    private void validateNumberOfWinningNumbers(int numberOfWinningNumbers) {
        if (numberOfWinningNumbers != LottoNumberConstant.REQUIRED_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_REQUIRED_COUNT);
        }
    }


    private void validateLottoNumber(int winningNumberId) {

        if (!(LottoNumberConstant.MIN_NUMBER <= winningNumberId && winningNumberId <= LottoNumberConstant.MAX_NUMBER)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }

    }

}
