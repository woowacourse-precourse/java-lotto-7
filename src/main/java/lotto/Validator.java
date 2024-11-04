package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private static final String ERROR_NOT_A_NUMBER = ERROR_PREFIX + "숫자만 입력해야 합니다.";
    private static final String ERROR_PURCHASE_AMOUNT_UNIT = ERROR_PREFIX + "구입 금액은 1,000원 단위로 입력해야 합니다.";
    private static final String ERROR_PURCHASE_AMOUNT_MINIMUM = ERROR_PREFIX + "구입 금액은 1,000원 이상이어야 합니다.";
    private static final String ERROR_DUPLICATE_NUMBERS = ERROR_PREFIX + "로또 번호는 중복된 숫자가 포함될 수 없습니다.";
    private static final String ERROR_LOTTO_SIZE = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    private static final String ERROR_NUMBER_RANGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_DUPLICATE = ERROR_PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public static void validateIsNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_UNIT);
        }
    }

    public static void validatePositiveAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_MINIMUM);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicateNumbers = new HashSet<>(numbers);
        if (checkDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
    }

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }

    public static void validateBonusDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
        }
    }
}
