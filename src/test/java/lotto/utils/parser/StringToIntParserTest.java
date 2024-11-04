package lotto.utils.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("[Utils] StringToIntParser")
public class StringToIntParserTest {
    private final StringToIntParser parser = new StringToIntParser();

    @Nested
    @DisplayName("[parse] 문자열의 int로의 파싱이 잘 이루어지는 지 테스트한다")
    class ParseTest{
        @Test
        @DisplayName("유효한 문자열이 들어오면 성공적으로 Int를 반한한다.")
        public void Given_ValidInput_When_ParseStringToInt_Then_ReturnInt() {
            // Given
            String rawNumber = "123";
            Integer expected = 123;

            // When
            Integer actual = parser.parse(rawNumber);

            // Then
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("음수 정수를 담고 있는 문자열이 들어오면 성공적으로 Int를 반한한다.")
        public void Given_NegativeInput_When_ParseStringToInt_Then_ReturnInt() {
            // Given
            String rawNumber = "-456";
            Integer expected = -456;

            // When
            Integer actual = parser.parse(rawNumber);

            // Then
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("0을 담고 있는 문자열이 들어오면 성공적으로 Int를 반한한다.")
        public void Given_Zero_When_ParseStringToInt_Then_ReturnInt() {
            // Given
            String rawNumber = "0";
            Integer expected = 0;

            // When
            Integer actual = parser.parse(rawNumber);

            // Then
            assertEquals(expected, actual);
        }
    }






}
