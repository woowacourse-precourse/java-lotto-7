package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialNumberTest {

    @DisplayName("입력값이 로또 숫자 범위를 벗어날 때")
    @ParameterizedTest
    @ValueSource(strings = {"46", "0"})
    void 입력값_범위_이탈(String specialNumber) {
        assertThatThrownBy(() -> new SpecialNumber(specialNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBER_MUST_BE_IN_CORRECT_RANGE.getMessage());
    }

    @DisplayName("입력값이 int 형식이 아닐때")
    @ParameterizedTest
    @ValueSource(strings = {"hi", "2200000000"})
    void 입력값_INT_아닐때(String specialNumber) {
        assertThatThrownBy(() -> new SpecialNumber(specialNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
    }

}