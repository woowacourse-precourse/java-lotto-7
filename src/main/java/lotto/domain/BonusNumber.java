package lotto.domain;

import java.util.List;
import java.util.Objects;

public class BonusNumber {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 %d와 %d사이 숫자여야합니다.";
    public static final String BONUS_NUMBER_DUPLICATE_MESSAGE = "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.";

    private final int value;

    private BonusNumber(int value, List<Integer> ticket) {
        validate(value, ticket);
        this.value = value;
    }

    public static BonusNumber of(int value, List<Integer> ticket) {
        return new BonusNumber(value, ticket);
    }

    private void validate(int value, List<Integer> ticket) {
        validateRange(value);
        validateDuplicate(value, ticket);
    }

    private void validateRange(int value) {
        if (value < MIN_RANGE || value > MAX_RANGE) {
            throw new IllegalArgumentException(String.format(BONUS_NUMBER_RANGE_ERROR_MESSAGE, MIN_RANGE, MAX_RANGE));
        }
    }

    private void validateDuplicate(int value, List<Integer> ticket) {
        if (containsDuplicateNumbers(value, ticket)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    private boolean containsDuplicateNumbers(int value, List<Integer> ticket) {
        return ticket.stream().anyMatch(n -> n == value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BonusNumber that = (BonusNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
