package lotto.support.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.exception.converter.InvalidConvertException;
import lotto.exception.validator.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Integer 변환기 테스트")
public class ConverterTest {

    @Nested
    @DisplayName("문자열 리스트 -> Integer 리스트")
    class 문자열리스트_Integer리스트_변환 {

        @Test
        @DisplayName("변환에 성공한다")
        void 성공_변환() {
            // Given
            List<String> numbers = List.of("1", "2");
            Converter converter = new Converter();

            // When & Then
            assertThat(converter.convertToInteger(numbers)).containsExactly(1, 2);
        }

        @Test
        @DisplayName("null일 경우 예외가 발생한다")
        void 실패_변환_null() {
            // Given
            Converter converter = new Converter();
            List<String> numbers = null;

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("null일 수 없습니다");
        }

        @Test
        @DisplayName("비어있을 경우 예외가 발생한다")
        void 실패_변환_비어있음() {
            // Given
            Converter converter = new Converter();
            List<String> numbers = Collections.emptyList();

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("숫자 목록은(는) 빈 문자열일 수 없습니다.");
        }

        @Test
        @DisplayName("빈 문자열이 포함될 경우 예외가 발생한다")
        void 실패_변환_빈문자열포함() {
            // Given
            Converter converter = new Converter();
            List<String> numbers = List.of("");

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("숫자은(는) 빈 문자열이거나 공백일 수 없습니다.");
        }

        @Test
        @DisplayName("문자열 안에 공백 포함될 경우 예외가 발생한다")
        void 실패_변환_공백포함() {
            // Given
            Converter converter = new Converter();
            List<String> numbers = List.of("1 0");

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidConvertException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("유효한 정수형식이어야 합니다.");
        }

        @Test
        @DisplayName("null이 포함될 경우 예외가 발생한다")
        void 실패_변환_null포함() {
            // Given
            Converter converter = new Converter();
            List<String> numbers = new ArrayList<>();
            numbers.add(null);

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("null일 수 없습니다");
        }

        @ParameterizedTest
        @MethodSource
        @DisplayName("Integer 타입 정수가 아닌 문자열일 경우 예외가 발생한다")
        void 실패_변환_정수X(List<String> numbers) {
            // Given
            Converter converter = new Converter();

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidConvertException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("유효한 정수형식이어야 합니다.");
        }

        private static Stream<Arguments> 실패_변환_정수X() {
            return Stream.of(
                    Arguments.of(List.of("2e20")),
                    Arguments.of(List.of("1.1")),
                    Arguments.of(List.of("a1"))
            );
        }
    }

    @Nested
    @DisplayName("문자열 -> Integer")
    class 문자열_Integer_변환 {

        @Test
        @DisplayName("변환에 성공한다")
        void 성공_변환() {
            // Given
            Converter converter = new Converter();

            // When & Then
            assertThat(converter.convertToInteger("1")).isEqualTo(1);
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "1.5", "2e20"})
        @DisplayName("정수가 아닐 경우 실패한다")
        void 실패_변환_정수X(String input) {
            // Given
            Converter converter = new Converter();

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidConvertException.class)
                    .hasMessageContaining("유효한 정수형식이어야 합니다.");
        }

        @Test
        @DisplayName("null일 경우 예외가 발생한다")
        void 실패_변환_null() {
            // Given
            Converter converter = new Converter();
            String number = null;

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("숫자은(는) null일 수 없습니다.");
        }

        @Test
        @DisplayName("비어있을 경우 예외가 발생한다")
        void 실패_변환_비어있음() {
            // Given
            Converter converter = new Converter();
            String number = "";

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("숫자은(는) 빈 문자열이거나 공백일 수 없습니다.");
        }

        @Test
        @DisplayName("공백일 경우 예외가 발생한다")
        void 실패_변환_공백() {
            // Given
            Converter converter = new Converter();
            String number = " ";

            // When & Then
            assertThatThrownBy(() -> converter.convertToInteger(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("숫자은(는) 빈 문자열이거나 공백일 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("문자열 -> BigDecimal")
    class 문자열_BigDecimal_변환 {

        @Test
        @DisplayName("변환에 성공한다")
        void 성공_변환() {
            // Given
            Converter converter = new Converter();

            // When & Then
            assertThat(converter.convertToBigDecimal("2e20")).isEqualTo(new BigDecimal("2e20"));
        }

        @ParameterizedTest
        @ValueSource(strings = {"ab", "1.1.3"})
        @DisplayName("실수가 아니면 예외가 발생한다")
        void 실패_변환_공백(String number) {
            // Given
            Converter converter = new Converter();

            // When & Then
            assertThatThrownBy(() -> converter.convertToBigDecimal(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidConvertException.class)
                    .hasMessageStartingWith("[ERROR] ")
                    .hasMessageContaining("유효한 실수형식이어야 합니다.");
        }
    }
}
