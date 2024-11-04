package lotto.validation;

import java.math.BigDecimal;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoEnum;
import lotto.utils.Utils;

public class Validator {
    public static void isEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public static void isDigitOnly(String userInput) {
        if (!Utils.isDigitOnly(userInput)) {
            throw new NumberFormatException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public static void allDigits(String[] numbers) {
        if (!Utils.allElementsAreDigits(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public static void sizeEqual(String[] numbers, int size) {
        if (!Utils.checkSizeEqual(numbers, size)) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    public static void allNumberRange(BigDecimal min, BigDecimal max, List<BigDecimal> winningNumber) {
        if (!Utils.areAllNumbersValidRange(min, max, winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public static void DuplicateNumber(List<BigDecimal> winningNumber) {
        if (!Utils.isDuplicateNumber(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void oneNumberRange(BigDecimal min, BigDecimal max, BigDecimal bonusNumber) {
        if (!Utils.isInRange(min, max, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }

    public static void isDuplicateBonusNumber(List<Integer> winningNumberData, int bonusNumber) {
        if (winningNumberData.contains(bonusNumber)) {
//        if (Utils.isNumberInList(winningNumberData, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    public static void checkLottoLength(int size) {
        if (size != LottoEnum.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }
}
