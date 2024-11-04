package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class Exception {
    private static final int MIN_AMOUNT = 1000;
    private static final String EMPTY_VALUE = "[ERROR] 비어있지 않은 문자열을 입력해주세요.";
    private static final String NO_INT_VALUE = "[ERROR] integer 타입의 숫자값을 입력해주세요.";
    private static final String NO_UNIT_VALUE = "[ERROR] 0이 아닌 1000 단위의 숫자값을 입력해주세요.";
    private static final String NO_DELIMITER = "[ERROR] 쉼표 구분자를 사용한 문자열을 입력해주세요.";

    private static final String INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String INVALID_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INVALID_UNIQUE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    private static final String INVALID_UNIQUE_BONUS = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";

    protected void validateString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_VALUE);
        }
    }

    protected void validateNumber(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_INT_VALUE);
        }
    }

    protected void validateUnit(String amount) {
        if (Integer.parseInt(amount) < MIN_AMOUNT) {
            throw new IllegalArgumentException(NO_UNIT_VALUE);
        }
        if ((Integer.parseInt(amount) % MIN_AMOUNT) != 0) {
            throw new IllegalArgumentException(NO_UNIT_VALUE);
        }
    }

    protected void validateDelimiter(String winningNumbers) {
        if (!winningNumbers.contains(",")) {
            throw new IllegalArgumentException(NO_DELIMITER);
        }
    }

    protected List<Integer> refineString(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String spiltNumber : splitNumbers) {
            try {
                int number = Integer.parseInt(spiltNumber);
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NO_INT_VALUE);
            }
        }
        return numbers;
    }

    public static void getInvalidSize() {
        throw new IllegalArgumentException(INVALID_SIZE);
    }

    public static void getInvalidRange() {
        throw new IllegalArgumentException(INVALID_RANGE);
    }

    public static void getInvalidUnique() {
        throw new IllegalArgumentException(INVALID_UNIQUE);
    }

    public static void getInvalidUniqueBonus() {
        throw new IllegalArgumentException(INVALID_UNIQUE_BONUS);
    }
}