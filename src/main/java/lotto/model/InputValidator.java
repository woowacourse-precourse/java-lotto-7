package lotto.model;

import static lotto.common.AppConstant.LOTTO_UNIT_PRICE;

public class InputValidator {
    public void validateInputMoney(String input) {
        validateParseNumber(input);
        validatePositiveNumber(input);
        validateOverLottoPrice(input);
        validateDivideByUnit(input);
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
}
