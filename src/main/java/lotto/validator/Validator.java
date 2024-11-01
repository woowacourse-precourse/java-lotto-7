package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.enums.Constants;
import lotto.enums.ErrorMessage;

public class Validator {
    public void validatePurchaseAmount(String price) {
        int convertedPrice = parseInteger(price);
        if (convertedPrice <= 0 || convertedPrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    public void validateLottoNumbers(String lottoNumbers) {
        List<String> numbers = Arrays.asList(lottoNumbers.split(","));

        if (numbers.size() != Constants.LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }

        for (String number : numbers) {
            if (!isValidRange(parseInteger(number))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
            }
        }
    }

    public void validateBonusNumber(String bonusNumber) {
        if (!isValidRange(parseInteger(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }
    }

    public void checkDuplicateLottoNumbers(String lottoNumbers, String bonusNumber) {
        List<String> numbers = Arrays.asList(lottoNumbers.split(","));
        List<Integer> allNumbers = new ArrayList<>();
        allNumbers.add(parseInteger(bonusNumber));

        for (String number : numbers) {
            int convertedNumber = parseInteger(number);
            if (allNumbers.contains(convertedNumber)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
            }
            allNumbers.add(convertedNumber);
        }
    }

    private int parseInteger(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }
        return num;
    }

    private boolean isValidRange(int num) {
        int startRange = Constants.LOTTO_START_RANGE.getValue();
        int finishRange = Constants.LOTTO_FINISH_RANGE.getValue();
        return num >= startRange && num <= finishRange;
    }
}
