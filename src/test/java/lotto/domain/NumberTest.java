package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.error.LottoErrorConstants;
import lotto.exception.number.NumberErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberTest {

    @ParameterizedTest
    @CsvSource(value = {
            "0", "-1", "100", "99", "46"
    })
    @DisplayName("유효하지 않은 숫자 인자로 받을 시 예외 발생")
    void testInvalidNumberException(int number) {
        //
        assertThatThrownBy(() -> new Number(number))
                .hasMessageContainingAll(
                        LottoErrorConstants.PREFIX_ERROR_MESSAGE + NumberErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1", "23", "45", "43", "2"
    })
    @DisplayName("유효한 숫자 인자로 받으면 예외 발생 하지 않음")
    void testValidNumber(int number) {
        // When & Then
        assertThatNoException().isThrownBy(() -> new Number(number));
    }
}