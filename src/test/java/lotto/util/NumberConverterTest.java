package lotto.util;

import lotto.exception.GeneralException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberConverterTest {

    private final NumberConverter converter = new NumberConverter();

    @Test
    @DisplayName("유효한 숫자 문자열 입력 시 해당 숫자로 변환된다.")
    void shouldConvertValidNumberString() {
        // given
        String input = "1";

        // when
        int result = converter.convertNumber(input);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 앞뒤로 공백이 포함되어 있다면 공백을 제거하고 숫자를 반환한다.")
    void shouldConvertValidNumberStringIncludingTrim() {
        // given
        String input = " 1 ";

        // when
        int result = converter.convertNumber(input);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("빈 문자열 입력 시에는 예외가 발생한다.")
    void shouldThrowExceptionForEmptyString() {
        // given
        String input = "";

        // when & then
        assertThatThrownBy(() -> converter.convertNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GeneralException.INVALID_NUMBER);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열 입력 시에 예외가 발생한다.")
    void shouldThrowExceptionForNonNumericString() {
        // given
        String input = "hi";

        // when & then
        assertThatThrownBy(() -> converter.convertNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GeneralException.INVALID_NUMBER);
    }

}
