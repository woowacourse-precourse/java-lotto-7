package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.enums.Constants;
import lotto.enums.ErrorMessage;
import lotto.util.Util;

public class Validator {
    public static void validatePurchaseAmount(String price) {
        int convertedPrice = Util.checkValidInteger(price);
        if (convertedPrice <= 0 || convertedPrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    public static void validateWinningNumbers(String lottoNumbers) {
        List<String> numbers = Arrays.asList(lottoNumbers.replaceAll(" ", "").split(","));

        if (numbers.size() != Constants.LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH.getMessage());
        }

        for (String number : numbers) {
            if (!isValidRange(Util.checkValidInteger(number))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
            }
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        if (!isValidRange(Util.checkValidInteger(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }
    }

    public static void checkDuplicateLottoNumbers(List<Integer> winningNumbers) {
        List<Integer> allNumbers = new ArrayList<>();

        for (int number : winningNumbers) {
            if (allNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
            }
            allNumbers.add(number);
        }
    }

    public static void checkDuplicateBonusNumbers(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> allNumbers = new ArrayList<>();
        allNumbers.add(bonusNumber);

        for (int number : winningNumbers) {
            if (allNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
            }
            allNumbers.add(number);
        }
    }

    private static boolean isValidRange(int num) {
        int startRange = Constants.LOTTO_START_RANGE.getValue();
        int finishRange = Constants.LOTTO_FINISH_RANGE.getValue();
        return num >= startRange && num <= finishRange;
    }
}
