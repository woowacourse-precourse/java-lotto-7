package lotto.util.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputParserTest {

    @Test
    void 문자열이_리스트로_정상변환시_예외발생하지않음() {
        String input = "1,32,45,3,2,6";
        assertDoesNotThrow(() -> InputParser.parseWinningNumbers(input));
    }

    @Test
    void 문자열이_리스트로_비정상변환시_예외발생() {
        String input = "1,32,47,3,2,6,7";
        assertThatThrownBy(() -> InputParser.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
