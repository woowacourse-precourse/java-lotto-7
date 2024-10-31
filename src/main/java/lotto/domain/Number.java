package lotto.domain;

import java.util.Objects;
import lotto.domain.exception.CustomErrorCode;
import lotto.domain.exception.CustomException;

public class Number {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final String CHECK_NOT_NUMBER = "^[+-]?\\d+$";

    private final int number;

    public static Number from(String number) {
        validateEmptyNumber(number);
        validateNotNumber(number);
        int lottoNumber = Integer.parseInt(number);
        validateNumberRange(lottoNumber);
        return new Number(lottoNumber);
    }

    public static Number from(int number) {
        validateNumberRange(number);
        return new Number(number);
    }

    private Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number that)) return false;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private static void validateEmptyNumber(String number) {
        if (number == null || number.isBlank()) {
            throw new CustomException(CustomErrorCode.EXCEPTION_EMPTY_NUMBER);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new CustomException(CustomErrorCode.EXCEPTION_LOTTO_RANGE);
        }
    }

    private static void validateNotNumber(String number) {
        if (!number.matches(CHECK_NOT_NUMBER)) {
            throw new CustomException(CustomErrorCode.EXCEPTION_NOT_NUMBER);
        }
    }
}
