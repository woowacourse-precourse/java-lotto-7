package lotto.validator;

import camp.nextstep.edu.missionutils.test.NsTest;

import lotto.Exception.WinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.Exception.LottoExceptionType.*;
import static lotto.utils.LottoRules.LOTTO_MIN_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberValidatorTest {
    private final WinningNumberValidator validator = new WinningNumberValidator();

    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - 빈값")
    @EmptySource
    void empty(String empty) {
        WinningNumberException exception = assertThrows(WinningNumberException.class, () -> validator.validate(empty));
        assertEquals(LOTTO_NUMBER_EMPTY_ERROR.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - 분리한 텍스트 빈 값")
    @ValueSource(strings = {"1,2,3,4,  ", "1, ,2,3,4,5"})
    void empty_text(String emptyText) {
        WinningNumberException exception = assertThrows(WinningNumberException.class,
                () -> validator.validate(emptyText));
        assertEquals(LOTTO_NUMBER_EMPTY_ERROR.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - NAN")
    @ValueSource(strings = {"1,2,s,3,4,5", "1,s,2,3,4,5", "3s,30,1,2,3,4"})
    void nan(String notANumberText) {
        WinningNumberException exception = assertThrows(WinningNumberException.class,
                () -> validator.validate(notANumberText));
        assertEquals(LOTTO_NUMBER_NAN_ERROR.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - 중복 숫자")
    @ValueSource(strings = {"1,2,2,3,4,5", "1,2,3,3,4,5", "2,4,5,6,7,2"})
    void duplicateNumber(String duplicateNumberText) {
        WinningNumberException exception = assertThrows(WinningNumberException.class,
                () -> validator.validate(duplicateNumberText));
        assertEquals(LOTTO_NUMBER_DUPLICATE_ERROR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("사용자 입력 예외 - 숫자 범위 다름")
    void invalidRange() {
        String invalidRangeText = (LOTTO_MIN_NUMBER - 1) + ",2,3,4,5,6";
        WinningNumberException exception = assertThrows(WinningNumberException.class,
                () -> validator.validate(invalidRangeText));
        assertEquals(LOTTO_NUMBER_RANGE_ERROR.getMessage(), exception.getMessage());
    }


    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - 숫자 개수 불일치")
    @ValueSource(strings = {"1,2,3", "1,2", "1,2,3,4,5"})
    void invalidCount(String invalidCountText) {
        WinningNumberException exception = assertThrows(WinningNumberException.class,
                () -> validator.validate(invalidCountText));
        assertEquals(LOTTO_NUMBER_COUNT_ERROR.getMessage(), exception.getMessage());
    }

}