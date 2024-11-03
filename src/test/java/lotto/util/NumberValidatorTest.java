package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {

    @DisplayName("입력이 정수가 아닐 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.2", "1-", "ab", "2,", "1k", ";2", ""})
    void 입력이_정수가_아닐_경우_예외를_발생한다(String input) {
        assertThatThrownBy(() -> NumberValidator.change(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 정수일 경우 결과를 반환한다.")
    @Test
    void 입력이_정수일_경우_결과를_반환한다() {
        String number = "12345";
        Integer correctNumber = 12345;

        Integer newNumber = NumberValidator.change(number);

        assertThat(newNumber).isEqualTo(correctNumber);
    }
}