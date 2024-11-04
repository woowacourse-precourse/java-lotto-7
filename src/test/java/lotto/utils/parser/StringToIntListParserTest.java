package lotto.utils.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("[Utils] StringToIntListParser")
public class StringToIntListParserTest {
    private final StringToIntListParser parser = new StringToIntListParser();

    @Nested
    @DisplayName("[parse] 문자열의 Int 리스트로의 파싱이 잘 이루어지는 지 테스트한다.")
    class ParseTest{
        @Test
        @DisplayName("[Parsing] 숫자와 Delimiter로 이루어진 문자열이 들어올 때 성공적으로 int List 로의 변환이 된다.")
        public void Given_ValidInput_When_ParseStringToIntList_Then_ReturnListOfInts() {
            // Given
            String rawNumbers = "1,2,3,4,5,6,7,8";
            List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

            // When
            List<Integer> actual = parser.parse(rawNumbers);

            // Then
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("[Parsing] 하나의 숫자로 이루어진 문자열이 들어와도 성공적으로 int List로의 변환이 된다")
        public void Given_ValidSingleValue_When_ParseStringToIntList_Then_ReturnListOfInts() {
            // Given
            String rawNumbers = "42";
            List<Integer> expected = List.of(42);

            // When
            List<Integer> actual = parser.parse(rawNumbers);

            // Then
            assertEquals(expected, actual);
        }
    }


}
