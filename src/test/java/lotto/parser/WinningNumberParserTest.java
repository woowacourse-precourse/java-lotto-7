package lotto.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.ErrorMessage;
import lotto.utils.parser.WinningNumberParser;
import lotto.utils.validator.WinningNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberParserTest {
    private final WinningNumberParser parser = new WinningNumberParser(new WinningNumberValidator());

    @DisplayName("빈 문자열 및 공백을 입력하면 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "\n",
            " ",
            "      "
    })
    void testEmptyInput(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE.toString());
    }

    @DisplayName("올바른 구분자가 포함되지 않으면 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1.2.3.4.5.6", "1:2:3:4:5:6"})
    void testHasDelimiter(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DELIMITER_ERROR_MESSAGE.toString());
    }

    @DisplayName("정수가 아닌 숫자가 포함된 경우 예외가 발생해야한다.")
    @Test
    void testNotNumber() {
        String input = "1.1,1.2,1.3,1.4,1.5,1.6";

        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WINNING_NUMBER_ERROR_MESSAGE.toString());
    }

    @DisplayName("6개의 숫자를 입력하지 않은 경우 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void testNumbersCount(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WINNING_NUMBER_COUNT_ERROR_MESSAGE.toString());
    }

    @DisplayName("1부터 45까지의 숫자를 입력하지 않은 경우 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,45", "1,2,3,4,5,46"})
    void testNumbersInRange(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WINNING_NUMBER_ERROR_MESSAGE.toString());
    }

    @DisplayName("서로 중복된 숫자가 포함된 경우 예외가 발생해야한다.")
    @Test
    void testDuplicateNumber() {
        String input = "1,2,3,4,5,1";
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WINNING_NUMBER_ERROR_MESSAGE.toString());
    }

    @DisplayName("정상적인 값을 입력하면 정수 리스트로 파싱되어야한다.")
    @Test
    void testValidInput() {
        String input = "1,2,3,4,5,45";
        List<Integer> parsedInput = parser.parse(input);

        assertThat(parsedInput).hasSize(6);
        assertThat(parsedInput).containsExactly(1, 2, 3, 4, 5, 45);
    }
}
