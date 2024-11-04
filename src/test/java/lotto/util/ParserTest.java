package lotto.util;

import lotto.exception.InputNumberFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("파싱 테스트")
class ParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"10", "10 ", " 10"})
    @DisplayName("문자를 숫자 형식으로 변환하는지")
    void parseStringToInt(String input) {
        assertThat(Parser.stringToInt(input)).isEqualTo(10);
    }

    @Test
    @DisplayName("문자를 ,로 구분하는지")
    void parseStringToArray() {
        assertThat(Parser.stringToArray("1,2,3,4,5,6")).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "number", "숫자", "!!"})
    @DisplayName("숫자가 아닌 형식이 입력됐을 때 예외처리 되는지")
    void parseStringToIntException(String input) {
        assertThatThrownBy(() -> Parser.stringToInt(input))
                .isInstanceOf(InputNumberFormatException.class)
                .hasMessage(ErrorMessage.INPUT_NUMBER_FORMAT);
    }
}
