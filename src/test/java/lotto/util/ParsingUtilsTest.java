package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParsingUtilsTest {

    @Test
    @DisplayName("정상적인 숫자 문자열을 정수로 파싱")
    void parseStringToInteger_ShouldParseValidStringToInteger() {
        String input = "123";
        int result = ParsingUtils.parseStringToInteger(input);

        assertThat(result).isEqualTo(123);
    }

    @Test
    @DisplayName("잘못된 숫자 형식 문자열을 정수로 파싱 시 예외 발생")
    void parseStringToInteger_ShouldThrowException_WhenInvalidFormat() {
        String input = "abc";

        assertThatThrownBy(() -> ParsingUtils.parseStringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("정상적인 쉼표로 구분된 문자열을 정수 리스트로 파싱")
    void parseStringToIntegerList_ShouldParseValidStringToList() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> result = ParsingUtils.parseStringToIntegerList(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("잘못된 형식의 문자열을 정수 리스트로 파싱 시 예외 발생")
    void parseStringToIntegerList_ShouldThrowException_WhenInvalidFormat() {
        String input = "1, 2, a, 4";

        assertThatThrownBy(() -> ParsingUtils.parseStringToIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_FORMAT_INVALID.getMessage());
    }

}
