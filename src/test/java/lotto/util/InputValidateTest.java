package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidateTest {

    @DisplayName("입력이 비어있거나 널이면 예외가 발생한다.")
    @Test
    void inputNullOtBlank() {
        assertThatThrownBy(() -> new InputValidate().blankValidate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void inputNotDigit() {
        assertThatThrownBy(() -> new InputValidate().isDigitValidate("a,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}