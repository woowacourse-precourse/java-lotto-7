package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int PURCHASE_UNIT = 1000;

    private static final String AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다.";
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 중복된 번호가 존재합니다.";

    // 구입 금액이 1,000원 단위인지 검증
    public static void validatePurchaseAmount(int amount) {
        if (amount % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MESSAGE);
        }
    }

    // 번호의 개수가 6개인지 검증
    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    // 번호 범위 검증
    public static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateSingleNumberRange(number);
        }
    }

    public static void validateSingleNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    // 중복 번호 검증
    public static void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }
}

