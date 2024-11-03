package lotto.application.util.StrinConverter;

import lotto.application.util.StringConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 변환기 테스트")
class StringConverterTest {

    @Nested
    @DisplayName("문자열을 정수로 변환할 때")
    class ConvertToInt {
        @DisplayName("숫자 형식의 문자열이면 정수로 변환")
        @ParameterizedTest
        @ValueSource(strings = {"1000", "0", "-1", "    123    "})
        void 숫자형식_문자열_정수변환_성공(String input) {

            // expect
            Assertions.assertThatCode(() -> StringConverter.toInt(input))
                    .doesNotThrowAnyException();
        }

        @DisplayName("공백을 제거하고 정수로 변환")
        @Test
        void 공백제거_정수변환_성공() {
            // given
            String input = "  123  ";

            // expect
            Assertions.assertThat(StringConverter.toInt(input)).isEqualTo(123);
        }

        @DisplayName("숫자 형식이 아닌 경우 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"abc", "12.34", "1,000", "@#$"})
        void 숫자형식_아닌경우_예외발생(String input) {

            // expect
            Assertions.assertThatThrownBy(() -> StringConverter.toInt(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 숫자로 변환할 수 없는 값입니다.");
        }

        @DisplayName("빈 문자열이나 null이면 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "  "})
        void 빈문자열_예외발생(String input) {

            // expect
            Assertions.assertThatThrownBy(() -> StringConverter.toInt(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 문자열은 공백일 수 없습니다.");
        }

        @Test
        @DisplayName("null 입력시 예외 발생")
        void null_입력시_예외발생() {

            // expect
            Assertions.assertThatThrownBy(() -> StringConverter.toInt(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 문자열은 null일 수 없습니다.");
        }

    }

}
