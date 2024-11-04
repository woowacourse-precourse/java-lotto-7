package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Verifier {

    public static void validateMoney(String value) {
        validateInteger(value);
        int money = Integer.parseInt(value);
        if (money < Lotto.PRICE || (money % Lotto.PRICE) != 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_MONEY.getMessage());
        }
    }

    public static void validateLottoNumbers(String[] values) {
        if (values.length != Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorType.NUMBER_COUNT.getMessage());
        }
        validateDuplicate(values);
        for (String value : values) {
            validateLottoNumber(value);
        }
    }

    public static void validateLottoNumbers(List<Integer> values) {
        if (values.size() != Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorType.NUMBER_COUNT.getMessage());
        }
        validateDuplicate(values);
        for (int value : values) {
            validateLottoNumber(value);
        }
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validateLottoNumber(bonusNumber);
        int bonus = Integer.parseInt(bonusNumber);
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorType.HAS_DUPLICATE.getMessage());
        }
    }

    public static void validateLottoNumber(String value) {
        validateInteger(value);
        validateLottoNumber(Integer.parseInt(value));
    }

    public static void validateLottoNumber(int value) {
        if (value < Lotto.START_RANGE || value > Lotto.END_RANGE) {
            throw new IllegalArgumentException(ErrorType.OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateDuplicate(String[] values) {
        Set<String> uniqueValues = new HashSet<>();
        for (String value : values) {
            if (!uniqueValues.add(value)) {
                throw new IllegalArgumentException(ErrorType.HAS_DUPLICATE.getMessage());
            }
        }
    }

    public static void validateDuplicate(List<Integer> values) {
        Set<Integer> uniqueValues = new HashSet<>(values);
        if (uniqueValues.size() != values.size()) {
            throw new IllegalArgumentException(ErrorType.HAS_DUPLICATE.getMessage());
        }
    }

    public static void validateInteger(String value) {
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorType.NOT_INTEGER.getMessage());
        }
    }
}
