package lotto;

import java.util.List;

enum ExceptionMessage {
    EMPTY_INPUT("[ERROR] 빈 문자열은 입력할 수 없습니다."),
    NOT_ONLY_NUMBER("[ERROR] 기타 문자나 단위 없이 양의 숫자만 입력하세요."),
    OUT_OF_RANGE_NUMBER(String.format("[ERROR] 입력 가능한 숫자는 0에서 %d 사이 입니다.", Integer.MAX_VALUE)),
    NOT_POSITIVE_NUMBER("[ERROR] 0보다 큰 양수를 입력하세요."),
    NOT_THOUSAND_DIVISIBLE("[ERROR] 1,000원 단위로 입력하세요"),
    NOT_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 값입니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복된 값을 가질 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class ExceptionHandler {
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    public static void isEmpty(String input) {
        ExceptionMessage exception = ExceptionMessage.EMPTY_INPUT;
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isOnlyNumber(String input) {
        ExceptionMessage exception = ExceptionMessage.NOT_ONLY_NUMBER;
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isBigNumber(String input) {
        ExceptionMessage exception = ExceptionMessage.OUT_OF_RANGE_NUMBER;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void validateNumeric(String input) {
        isEmpty(input);
        isOnlyNumber(input);
        isBigNumber(input);
    }

    public static void isPositiveNumber(int input) {
        ExceptionMessage exception = ExceptionMessage.NOT_POSITIVE_NUMBER;
        if (input <= 0) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isThousandDivisible(int input) {
        ExceptionMessage exception = ExceptionMessage.NOT_THOUSAND_DIVISIBLE;
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isLottoNumber(int input) {
        ExceptionMessage exception = ExceptionMessage.NOT_LOTTO_NUMBER;
        if (input < LOTTO_MIN || input > LOTTO_MAX) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void validateLottoNumber(List<Integer> input) {
        ExceptionMessage exception = ExceptionMessage.INVALID_LOTTO_SIZE;
        if (input.size() != 6) {
            throw new IllegalArgumentException(exception.getMessage());
        }
        for (int number : input) {
            isLottoNumber(number);
        }
        hasDuplicates(input);
    }

    // 숫자 리스트 내에 중복값이 존재하면 예외를 발생한다.
    public static void hasDuplicates(List<Integer> numbers) {
        ExceptionMessage exception = ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    // 인자로 받은 숫자가 숫자 리스트 내에 존재하면 예외를 발생한다.
    public static void hasDuplicates(List<Integer> numbers, int value) {
        ExceptionMessage exception = ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
        if (numbers.contains(value)) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }
}
