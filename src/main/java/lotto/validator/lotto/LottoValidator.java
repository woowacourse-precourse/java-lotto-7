package lotto.validator.lotto;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.lotto.LottoConstant;
import lotto.error.lotto.LottoErrorMessage;

public class LottoValidator {

    public void validatePurchaseAmount(String amount) {
        validatePurchaseAmountType(amount);
        validatePurchaseAmountMultiple(amount);
        validatePurchaseAmountLimit(amount);
    }

    private void validatePurchaseAmountType(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoErrorMessage.INPUT_DATA_IS_NOT_POSITIVE);
        }
    }

    private void validatePurchaseAmountMultiple(String amount) {
        int amountOfInt = Integer.parseInt(amount);
        if (amountOfInt % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_PURCHASE_POLICY);
        }
    }

    private void validatePurchaseAmountLimit(String amount) {
        int amountOfInt = Integer.parseInt(amount);
        if (amountOfInt > LottoConstant.LOTTO_PRICE * 100) {
            throw new IllegalArgumentException(LottoErrorMessage.OUT_OF_PURCHASE_LIMIT);
        }
    }


    public void validateWinningNumbers(String numbers) {
        Set<Integer> winningNumbers = validateWinningNumbersPattern(numbers);
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
    }

    private Set<Integer> validateWinningNumbersPattern(String numbers) {
        String[] numbersOfText;
        try {
            numbersOfText = numbers.split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoErrorMessage.INPUT_DATA_IS_NOT_POSITIVE_OR_DELIMITER);
        }

        Set<Integer> winningNumbers = new HashSet<>();
        for (String numberOfText : numbersOfText) {
            int lottoNumber = Integer.parseInt(numberOfText);
            if (winningNumbers.contains(lottoNumber)) {
                throw new IllegalArgumentException(LottoErrorMessage.DUPLICATED_LOTTO_NUMBERS);
            }
            winningNumbers.add(lottoNumber);
        }
        return winningNumbers;
    }

    private void validateWinningNumbersCount(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstant.LOTTO_WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_NUMBER_OF_WINNING_NUMBERS);
        }
    }

    private void validateWinningNumbersRange(Set<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (isInvalidNumberRange(winningNumber)) {
                throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    public void validateBonusNumber(Set<Integer> winningNumbers, String inputBonusNumber) {
        validateBonusNumberType(inputBonusNumber);
        validateBonusNumberRange(inputBonusNumber);
        validateBonusNumberDuplicated(winningNumbers, inputBonusNumber);
    }

    private void validateBonusNumberType(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoErrorMessage.INPUT_DATA_IS_NOT_POSITIVE);
        }
    }

    private void validateBonusNumberRange(String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (isInvalidNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    private void validateBonusNumberDuplicated(Set<Integer> winningNumbers, String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATED_LOTTO_NUMBERS);
        }
    }

    private boolean isInvalidNumberRange(Integer lottoNumber) {
        if (!(LottoConstant.LOTTO_RANGE_LEFT <= lottoNumber && lottoNumber <= LottoConstant.LOTTO_RANGE_RIGHT)) {
            return true;
        }
        return false;
    }
}
