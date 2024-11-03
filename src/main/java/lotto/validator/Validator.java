package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.enums.Constants;
import lotto.enums.ErrorMessage;
import lotto.util.Util;

public class Validator {
    public void validatePurchaseAmount(String price) {
        int convertedPrice = Util.checkValidInteger(price);
        if (convertedPrice <= 0 || convertedPrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    public void validateWinningNumbers(String lottoNumbers) {
        List<String> numbers = Arrays.asList(lottoNumbers.replaceAll(" ", "").split(","));

        if (numbers.size() != Constants.LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }

        for (String number : numbers) {
            if (!isValidRange(Util.checkValidInteger(number))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
            }
        }
    }

    public void validateBonusNumber(String bonusNumber) {
        if (!isValidRange(Util.checkValidInteger(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }
    }

    public void checkDuplicateLottoNumbers(String winningNumbers, String bonusNumber) {
        List<String> numbers = Arrays.asList(winningNumbers.split(","));
        List<Integer> allNumbers = new ArrayList<>();
        allNumbers.add(Util.checkValidInteger(bonusNumber));

        for (String number : numbers) {
            int convertedNumber = Util.checkValidInteger(number);
            if (allNumbers.contains(convertedNumber)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
            }
            allNumbers.add(convertedNumber);
        }
    }

    private boolean isValidRange(int num) {
        int startRange = Constants.LOTTO_START_RANGE.getValue();
        int finishRange = Constants.LOTTO_FINISH_RANGE.getValue();
        return num >= startRange && num <= finishRange;
    }
}
