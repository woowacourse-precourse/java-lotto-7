package validator;

import static common.ErrorMessage.INVALID_LOTTO_CONTAINS;
import static common.ErrorMessage.INVALID_LOTTO_NUMBER;
import static common.ErrorMessage.INVALID_LOTTO_SCOPE;
import static common.ErrorMessage.INVALID_PRICE;
import static common.ErrorMessage.INVALID_TYPE;
import static common.ErrorMessage.INVALID_VALUE_NEGATIVE;
import static common.ErrorMessage.INVALID_VALUE_ZERO;
import static common.ErrorMessage.NONE_INPUT;

import java.util.Arrays;
import java.util.List;
import model.Lotto;

public class InputValidator {
    public static void validatePurchaseAmount(String purchaseAmount) {
        inputEmptyCheck(purchaseAmount);
        inputNotInteger(purchaseAmount);
        inputNegative(purchaseAmount);
        inputZero(purchaseAmount);
        inputInvalidCalculableValue(purchaseAmount);
    }

    public static void validateWinningNumbers(String winningNumbers) {
        inputEmptyCheck(winningNumbers);
        List<Integer> LottoNumbers = checkWinningNumbers(winningNumbers);
        new Lotto(LottoNumbers);
    }

    public static void validateWinningBonusNumbers(String winningBonusNumber, String winningNumbers) {
        inputEmptyCheck(winningBonusNumber);
        inputNotInteger(winningBonusNumber);

        List<Integer> parseWinningNumbers = checkWinningNumbers(winningNumbers);
        int parseBonusNumber = Integer.parseInt(winningBonusNumber);

        checkBonusNumberDuplicate(parseWinningNumbers, parseBonusNumber);
        checkRangeNumber(parseBonusNumber);
    }

    private static List<Integer> checkWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(number -> {
                    try {
                        int lottoNumber = Integer.parseInt(number);
                        checkRangeNumber(lottoNumber);
                        return lottoNumber;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
                    }
                })
                .toList();
    }

    private static void checkRangeNumber(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException(INVALID_LOTTO_SCOPE.getMessage());
        }
    }

    private static void inputEmptyCheck(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(NONE_INPUT.getMessage());
        }
    }

    private static void inputNotInteger(String purchaseAmount) {
        try {
            int result = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }

    private static void inputNegative(String purchaseAmount) {
        int result = Integer.parseInt(purchaseAmount);
        if (result < 0) {
            throw new IllegalArgumentException(INVALID_VALUE_NEGATIVE.getMessage());
        }
    }

    private static void inputZero(String purchaseAmount) {
        int result = Integer.parseInt(purchaseAmount);
        if (result == 0) {
            throw new IllegalArgumentException(INVALID_VALUE_ZERO.getMessage());
        }
    }

    private static void inputInvalidCalculableValue(String purchaseAmount) {
        int result = Integer.parseInt(purchaseAmount);
        if (result % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PRICE.getMessage());
        }
    }

    private static void checkBonusNumberDuplicate(List<Integer> parseWinningNumbers, int parseBonusNumber) {
        if (parseWinningNumbers.contains(parseBonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_CONTAINS.getMessage());
        }
    }
}
