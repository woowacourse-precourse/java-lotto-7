package lotto.validator;

import lotto.Exception.BonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.Exception.LottoExceptionType.*;
import static lotto.utils.LottoRules.LOTTO_MAX_NUMBER;
import static lotto.utils.LottoRules.LOTTO_MIN_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberValidatorTest {
    private final BonusNumberValidator validator = new BonusNumberValidator();

    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - 빈값")
    @EmptySource
    void empty(String empty) {
        BonusNumberException exception = assertThrows(BonusNumberException.class, () -> validator.validate(empty));
        assertEquals(LOTTO_NUMBER_EMPTY_ERROR.getMessage(), exception.getMessage());
    }


    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - NAN")
    @ValueSource(strings = {"s", "s12"})
    void nan(String notANumberText) {
        BonusNumberException exception = assertThrows(BonusNumberException.class,
                () -> validator.validate(notANumberText));
        assertEquals(LOTTO_NUMBER_NAN_ERROR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("사용자 입력 예외 - 숫자 범위 다름")
    void invalidRange() {
        String outOfRangeMinText = String.valueOf(LOTTO_MIN_NUMBER - 1);
        BonusNumberException exception = assertThrows(BonusNumberException.class,
                () -> validator.validate(outOfRangeMinText));
        assertEquals(LOTTO_NUMBER_RANGE_ERROR.getMessage(), exception.getMessage());

        String outOfRangeMaxText = String.valueOf(LOTTO_MAX_NUMBER + 1);
        BonusNumberException exception2 = assertThrows(BonusNumberException.class,
                () -> validator.validate(outOfRangeMaxText));
        assertEquals(LOTTO_NUMBER_RANGE_ERROR.getMessage(), exception2.getMessage());
    }
}