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
    public static void isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            ExceptionMessage exception = ExceptionMessage.EMPTY_INPUT;
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isOnlyNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            ExceptionMessage exception = ExceptionMessage.NOT_ONLY_NUMBER;
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isBigNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ExceptionMessage exception = ExceptionMessage.OUT_OF_RANGE_NUMBER;
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void validateNumeric(String input) {
        isEmpty(input);
        isOnlyNumber(input);
        isBigNumber(input);
    }

    public static void isPositiveNumber(int input) {
        if (input <= 0) {
            ExceptionMessage exception = ExceptionMessage.NOT_POSITIVE_NUMBER;
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    /**
     * 구입 금액이 로또 가격(미션 요구사항에서는 1,000)으로 나누어 떨어지지 않으면 예외를 발생한다.
     */
    public static void isLottoPriceDivisible(int input) {
        if (input % LottoMeta.LOTTO_PRICE.getValue() != 0) {
            ExceptionMessage exception = ExceptionMessage.NOT_THOUSAND_DIVISIBLE;
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isLottoNumber(int input) {
        if (input < LottoMeta.LOTTO_MIN.getValue() || input > LottoMeta.LOTTO_MAX.getValue()) {
            ExceptionMessage exception = ExceptionMessage.NOT_LOTTO_NUMBER;
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void validateLottoNumber(List<Integer> input) {
        if (input.size() != LottoMeta.LOTTO_SIZE.getValue()) {
            ExceptionMessage exception = ExceptionMessage.INVALID_LOTTO_SIZE;
            throw new IllegalArgumentException(exception.getMessage());
        }
        for (int number : input) {
            isLottoNumber(number);
        }
        hasDuplicates(input);
    }

    /**
     * 숫자 리스트 내에 중복값이 존재하면 예외를 발생한다.
     */
    public static void hasDuplicates(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (distinctNumbers.size() != numbers.size()) {
            ExceptionMessage exception = ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    // 인자로 받은 숫자가 숫자 리스트 내에 존재하면 예외를 발생한다.

    /**
     * 인자로 받은 숫자가 숫자 리스트 내에 존재하면 예외를 발생한다.
     */
    public static void hasDuplicates(List<Integer> numbers, int value) {
        if (numbers.contains(value)) {
            ExceptionMessage exception = ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
            throw new IllegalArgumentException(exception.getMessage());
        }
    }
}
