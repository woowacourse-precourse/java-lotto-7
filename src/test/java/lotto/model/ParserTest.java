package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    @DisplayName("입력 문자열 정수로 변환 - 성공 테스트")
    void parseInputToInt_success() {
        // given
        String input = "1";

        // when
        Integer parsedInput = Parser.parseInputToInt(input);

        // then
        assertThat(parsedInput).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 문자 - 예외 테스트")
    void parseInputToInt_string() {
        // given
        String input = "a";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 특수 문자 - 예외 테스트")
    void parseInputToInt_specialCharacter() {
        // given
        String input = "$";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 빈 값 - 예외 테스트")
    void parseInputToInt_emptyValue() {
        // given
        String input = "";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 공백 - 예외 테스트")
    void parseInputToInt_whiteSpace() {
        // given
        String input = " ";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}