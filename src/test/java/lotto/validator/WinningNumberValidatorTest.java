package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberValidatorTest {

    @DisplayName("당첨 번호는 1~45 사이의 양의 정수여야 하며 6개의 숫자가 서로 중복되선 안 된다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,1,2,3,4,5", "-1,1,2,3,4,5", "1,2,3,4,5,46", "1,1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validateWinningNumber(String winningNumber) {
        assertThatThrownBy(() -> {
            WinningNumberValidator.validateWinningNumber(winningNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}