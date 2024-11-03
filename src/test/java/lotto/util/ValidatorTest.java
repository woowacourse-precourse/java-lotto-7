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
}