package lotto.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 입력이_비어있으면_예외_발생() {
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateEmptyInput(input);
        }, "입력이 비어있으면 예외 발생");
    }

    @Test
    void 입력이_null이면_예외_발생() {
        String input = null;

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateEmptyInput(input);
        }, "입력이 null이면 예외 발생");
    }

    @Test
    void 정수가_아닐_경우_예외_발생() {
        String input = "abc";

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNonNumber(input);
        }, "정수가 아닐 경우 예외 발생");
    }

    @Test
    void int범위를_벗어난_경우_예외_발생() {
        String input = String.valueOf(Long.MAX_VALUE);;

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNonNumber(input);
        }, "int 범위를 벗어난 경우 예외 발생");
    }

    @Test
    void 양수가_아닐_경우_예외_발생() {
        String input = "-1";

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validatePositiveNumber(input);
        }, "양수가 아닐 경우 예외 발생");
    }
}