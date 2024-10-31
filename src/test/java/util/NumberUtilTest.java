package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilTest {

    @DisplayName("숫자가 아니면 예외 처리")
    @Test
    void convertNumberFrom() {
        // given
        String userInput = "100aa";

        // when // then
        assertThatThrownBy(() -> NumberUtil.convertNumberFrom(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
    }

    @DisplayName("음수이면 예외 처리")
    @Test
    void isNotPositive() {
        // given
        int number = -2;

        // when // then
        assertThatThrownBy(() -> NumberUtil.isNotPositive(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
    }

    @DisplayName("0이면 예외 처리")
    @Test
    void isZeroNumber() {
        // given
        int number = 0;

        // when // then
        assertThatThrownBy(() -> NumberUtil.isZeroNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
    }

}