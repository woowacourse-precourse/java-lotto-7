package lotto;

import java.util.List;

public class Validator {
    public void validateDivisibleBy(long number, int divisor) {
        final boolean isDivisible = number % divisor == 0;
        if (!isDivisible) {
            throw new IllegalArgumentException(divisor + "로 나눌 수 없습니다.");
        }
    }

    public void validatePositiveValue(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("음수를 입력하면 안됩니다.");
        }
    }

    public void validateCanBeParsedToInteger(String number) {
        try {
            final long result = Long.parseLong(number);
            if (result > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("너무 큰 숫자 입력을 하였습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public void validateCanBeParsedToLong(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public void validateCommaSeparatedList(String input) {
        final String[] splitValue = input.split(",");
        final long commaCount = input.chars().filter((c -> c == ',')).count();
        if (splitValue.length != commaCount + 1) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    public void validateNumberHaveValidRange(long number, long min, long max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException("유효하지 않은 범위의 입력을 시도하였습니다.");
        }
    }

    public void validateIncludeDuplicateNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("중복 숫자가 입력되었습니다.");
        }
    }
}
