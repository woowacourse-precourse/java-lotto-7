package lotto.support;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.exception.InvalidConvertException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("정수 변환기 테스트")
public class IntegerConverterTest {

    @Test
    @DisplayName("문자열 리스트를 Integer 리스트로 변환한다")
    void 성공_변환() {
        // Given
        List<String> numbers = List.of("1", "2");
        IntegerConverter converter = new IntegerConverter();

        // When & Then
        assertThat(converter.convertFrom(numbers)).containsExactly(1, 2);
    }

    @Test
    @DisplayName("null일 경우 예외가 발생한다")
    void 실패_변환_null() {
        // Given
        IntegerConverter converter = new IntegerConverter();
        List<String> numbers = null;

        // When & Then
        assertThatThrownBy(() -> converter.convertFrom(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(InvalidConvertException.class)
                .hasMessageStartingWith("[ERROR] ")
                .hasMessageContaining("null일 수 없습니다");
    }

    @Test
    @DisplayName("빈 문자열이 포함될 경우 예외가 발생한다")
    void 실패_변환_빈문자열포함() {
        // Given
        IntegerConverter converter = new IntegerConverter();
        List<String> numbers = List.of("");

        // When & Then
        assertThatThrownBy(() -> converter.convertFrom(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(InvalidConvertException.class)
                .hasMessageStartingWith("[ERROR] ")
                .hasMessageContaining("Integer 타입의 정수가 아닙니다");
    }

    @Test
    @DisplayName("공백 포함될 경우 예외가 발생한다")
    void 실패_변환_공백포함() {
        // Given
        IntegerConverter converter = new IntegerConverter();
        List<String> numbers = List.of("1 ");

        // When & Then
        assertThatThrownBy(() -> converter.convertFrom(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(InvalidConvertException.class)
                .hasMessageStartingWith("[ERROR] ")
                .hasMessageContaining("Integer 타입의 정수가 아닙니다");
    }

    @Test
    @DisplayName("null이 포함될 경우 예외가 발생한다")
    void 실패_변환_null포함() {
        // Given
        IntegerConverter converter = new IntegerConverter();
        List<String> numbers = new ArrayList<>();
        numbers.add(null);

        // When & Then
        assertThatThrownBy(() -> converter.convertFrom(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(InvalidConvertException.class)
                .hasMessageStartingWith("[ERROR] ")
                .hasMessageContaining("Integer 타입의 정수가 아닙니다");
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Integer 타입 정수가 아닌 문자열일 경우 예외가 발생한다")
    void 실패_변환_정수X(List<String> numbers) {
        // Given
        IntegerConverter converter = new IntegerConverter();

        // When & Then
        assertThatThrownBy(() -> converter.convertFrom(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(InvalidConvertException.class)
                .hasMessageStartingWith("[ERROR] ")
                .hasMessageContaining("Integer 타입의 정수가 아닙니다");
    }

    private static Stream<Arguments> 실패_변환_정수X() {
        return Stream.of(
                Arguments.of(List.of("e20")),
                Arguments.of(List.of("1.1")),
                Arguments.of(List.of("a1"))
        );
    }
}
