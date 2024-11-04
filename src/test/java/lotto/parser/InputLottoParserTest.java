package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputLottoParserTest {

    @Test
    @DisplayName("성공 - 유효한 로또 번호 입력")
    void success_parseValidInput() {
        // given
        ParserConfig config = ParserConfig.DEFAULT;
        Parser parser = new InputLottoParser(config);
        String input = "1,2,3,4,5,6";

        // when
        String[] parsedNumbers = parser.parse(input);

        // then
        assertThat(parsedNumbers).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("실패 - 빈 입력")
    void fail_parseEmptyInput() {
        // given
        ParserConfig config = ParserConfig.DEFAULT;
        Parser parser = new InputLottoParser(config);
        String input = "";

        // when & then
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 정확히 6개여야 합니다.");
    }

    @Test
    @DisplayName("실패 - 번호가 6개 미만")
    void fail_parseLessThanSixNumbers() {
        // given
        ParserConfig config = ParserConfig.DEFAULT;
        Parser parser = new InputLottoParser(config);
        String input = "1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 정확히 6개여야 합니다.");
    }

    @Test
    @DisplayName("실패 - 중복된 번호 포함")
    void fail_parseDuplicateNumbers() {
        // given
        ParserConfig config = ParserConfig.DEFAULT;
        Parser parser = new InputLottoParser(config);
        String input = "1,2,3,3,5,6";

        // when & then
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호에 중복된 숫자가 포함되어 있습니다: 3");
    }

    @Test
    @DisplayName("실패 - 범위를 벗어난 번호 포함")
    void fail_parseOutOfRangeNumbers() {
        // given
        ParserConfig config = ParserConfig.DEFAULT;
        Parser parser = new InputLottoParser(config);
        String input = "1,2,3,4,5,46";

        // when & then
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 1 이상 45 이하의 양의 정수만 입력 가능합니다. 현재 숫자: 46");
    }

    @Test
    @DisplayName("실패 - 숫자가 아닌 입력 포함")
    void fail_parseNonNumericInput() {
        // given
        ParserConfig config = ParserConfig.DEFAULT;
        Parser parser = new InputLottoParser(config);
        String input = "1,2,3,4,5,abc";

        // when & then
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
