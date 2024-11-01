package lotto.validator;

import lotto.Exception.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {
    private final NumberValidator validator = new NumberValidator();

    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - 빈값")
    @EmptySource
    void empty(String empty) {
        assertThrows(NullOrEmptyException.class, () -> {
            validator.validate(empty);
        });
    }

    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - NAN")
    @ValueSource(strings = {"12s","1..2","300s"})
    void nan(String notANumberText) {
        assertThrows(NotANumberException.class, () -> {
            validator.validate(notANumberText);
        });
    }
}