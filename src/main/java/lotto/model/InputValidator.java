package lotto.model;

import static lotto.common.AppConstant.LOTTO_END_RANGE;
import static lotto.common.AppConstant.LOTTO_NUMBER_COUNT;
import static lotto.common.AppConstant.LOTTO_START_RANGE;
import static lotto.common.AppConstant.LOTTO_UNIT_PRICE;
import static lotto.common.AppConstant.SPLIT_DELIMITER;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    public void validateInputMoney(String input) {
        validateParseNumber(input);
        validatePositiveNumber(input);
        validateOverLottoPrice(input);
        validateDivideByUnit(input);
    }

    public void validateInputWinningNumber(String input) {
        List<String> splitWinningNumber = Arrays.stream(input.split(SPLIT_DELIMITER)).toList();
        validateNumberListSize(splitWinningNumber);

        splitWinningNumber.forEach(number -> {
            validateParseNumber(number);
            validateRangeNumber(number);
            validatePositiveNumber(number);
        });
    }

    private void validateParseNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    private void validatePositiveNumber(String input) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput < 0) {
            throw new IllegalArgumentException("양수 값을 입력해주세요.");
        }
    }

    private void validateOverLottoPrice(String input) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException(LOTTO_UNIT_PRICE + "원 이상의 값을 입력해주세요.");
        }
    }

    private void validateDivideByUnit(String input) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput % LOTTO_UNIT_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_UNIT_PRICE + "원 단위의 값을 입력해주세요.");
        }
    }

    private void validateNumberListSize(List<String> numberList) {
        if (numberList.size() != LOTTO_NUMBER_COUNT) {
            String errorMessage = "(" + SPLIT_DELIMITER + ")로 구분된 " + LOTTO_NUMBER_COUNT + "개의 숫자를 입력해주세요.";

            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateRangeNumber(String input) {
        int parsedInt = Integer.parseInt(input);

        if (LOTTO_START_RANGE > parsedInt || parsedInt > LOTTO_END_RANGE) {
            throw new IllegalArgumentException(LOTTO_START_RANGE + "에서 " + LOTTO_END_RANGE + "사이의 값을 입력해주세요.");
        }
    }
}
