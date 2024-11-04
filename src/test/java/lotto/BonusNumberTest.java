package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("입력값이 로또 숫자 범위를 벗어날 때")
    @ParameterizedTest
    @ValueSource(strings = {"46", "0"})
    void 입력값_범위_이탈(String bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("입력값이 int 형식이 아닐때")
    @ParameterizedTest
    @ValueSource(strings = {"joonil", "111111"})
    void 입력값_INT_아닐때(String bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.FAILED_TO_PARSE_INTEGER.getMessage());
    }

}