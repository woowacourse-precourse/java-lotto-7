// InputValidator.java
package validator;

import static view.message.ExceptionMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.INVALID_UNIT_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.LIMIT_EXCEED_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.MAX_PURCHASE_AMOUNT_TEN_THOUSAND;
import static view.message.ExceptionMessage.NEGATIVE_NUMBER_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.THOUSAND_UNIT;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validatePurchaseAmount(BigDecimal purchaseAmount) {
        validateNegativeNumber(purchaseAmount);
        validatePurchaseAmountLimit(purchaseAmount);
        validateThousandUnit(purchaseAmount);
    }

    private static void validateNegativeNumber(BigDecimal purchaseAmount) {
        if (purchaseAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void validatePurchaseAmountLimit(BigDecimal purchaseAmount) {
        if (purchaseAmount.compareTo(MAX_PURCHASE_AMOUNT_TEN_THOUSAND) > 0) {
            throw new IllegalArgumentException(LIMIT_EXCEED_EXCEPTION_MESSAGE);
        }
    }

    private static void validateThousandUnit(BigDecimal purchaseAmount) {
        if (purchaseAmount.remainder(THOUSAND_UNIT)
                          .compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateLottoNumbersCount(numbers);
        validateLottoNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private static void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE + number);
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(lottoNumbers, bonusNumber);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateBonusNumberDuplicate(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }

}
