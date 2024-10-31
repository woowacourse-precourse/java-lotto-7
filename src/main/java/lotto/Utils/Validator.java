package lotto.Utils;

import lotto.Enum.ExceptionCode;

import java.util.Arrays;
import java.util.List;

public class Validator {

    // LOTTO_01, LOTTO_03 은 Lotto 클래스 안에서 검증

    // LOTTO_02 (int)
    public void validateBonusRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_RANGE.getMessage());
        }
    }

    // LOTTO_04
    public List<Integer> validateNumbersInput(String lottoInput) {
        try {
            return Arrays.stream(lottoInput.split(", |,")).map(Integer::parseInt).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_LOTTO_INPUT.getMessage());
        }
    }

    // TYPE_01
    public int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_TYPE.getMessage());
        }
    }

    // PRICE_01
    public void validatePrice1000(int priceInput) {
        if (priceInput % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_PRICE.getMessage());
        }
    }

    // NULL_01
    public void validateEmptyInput(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ExceptionCode.NULL_INPUT.getMessage());
        }
    }
}
