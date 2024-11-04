package lotto.view.input.parser;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTests {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "5000", "10000"})
    void testParsePurchaseAmountValidInput(String input) {
        int result = InputParser.parsePurchaseAmount(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"해광", "1.5", "", " "})
    void testParsePurchaseAmountInvalidInputThrowsException(String input) {
        assertThatThrownBy(() -> InputParser.parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"7", "15", "45"})
    void testParseWinningLottoBonusNumberValidInput(String input) {
        int result = InputParser.parseWinningLottoBonusNumber(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"x", "33.0"})
    void testParseWinningLottoBonusNumberInvalidInputThrowsException(String input) {
        assertThatThrownBy(() -> InputParser.parseWinningLottoBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
    }

    @Test
    void testParseWinningLottoNumbersValidInput() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = InputParser.parseWinningLottoNumbers(input);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "1, ,3", ",,,", "1,2,three"})
    void testParseWinningLottoNumbersInvalidInputThrowsException(String input) {
        assertThatThrownBy(() -> InputParser.parseWinningLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
    }
}