package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberValidatorTest {
    @ParameterizedTest
    @DisplayName("잘못된 범위 내의 숫자가 들어왔을시, 오류를 발생합니다.")
    @ValueSource(ints = {0, 46, -1, 50})
    void 숫자_범위를_확인합니다(int target) {
        assertThatThrownBy(() -> NumberValidator.validateNumberRange(target, 1, 45))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("정수가 아닌 입력이 들어왔을 경우 오류를 발생합니다.")
    @ValueSource(strings = {" ", "\n", ".", "/", "dd", "^"})
    void 정수인지_확인합니다(String target) {
        assertThatThrownBy(() -> NumberValidator.validateInt(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_DIGIT.getMessage());
    }
}
