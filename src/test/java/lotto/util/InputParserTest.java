package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.InputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

    @Test
    @DisplayName("로또 가격 입력값이 비어있으면 IllegalArgumentException 발생")
    void parseLottoPrice_EmptyInput_ExceptionThrown() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> InputParser.parseLottoPrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
    }

    @Test
    @DisplayName("로또 가격 입력값이 null이면 IllegalArgumentException 발생")
    void parseLottoPrice_NullInput_ExceptionThrown() {
        // given
        String input = null;

        // when, then
        assertThatThrownBy(() -> InputParser.parseLottoPrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
    }

    @ValueSource(strings = {"   ", "abc", "1.1"})
    @ParameterizedTest(name = "로또 가격 입력값이 {0}이면 IllegalArgumentException 발생")
    @DisplayName("로또 가격 입력값이 숫자가 아니면 IllegalArgumentException 발생")
    void parseLottoPrice_NotNumberInput_ExceptionThrown(String input) {
        // given

        // when, then
        assertThatThrownBy(() -> InputParser.parseLottoPrice(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 입력값 파싱 성공")
    void parseLottoPrice_Success() {
        // given
        String input = "1000";

        // when
        int result = InputParser.parseLottoPrice(input);

        // then
        assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("당첨 번호 입력값이 비어있으면 IllegalArgumentException 발생")
    void parseWinningNumbers_EmptyInput_ExceptionThrown() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> InputParser.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 입력값이 null이면 IllegalArgumentException 발생")
    void parseWinningNumbers_NullInput_ExceptionThrown() {
        // given
        String input = null;

        // when, then
        assertThatThrownBy(() -> InputParser.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 입력값이 숫자가 아니면 IllegalArgumentException 발생")
    void parseWinningNumbers_NotNumberInput_ExceptionThrown() {
        // given
        String input = "1,2,3,4,a";

        // when, then
        assertThatThrownBy(() -> InputParser.parseWinningNumbers(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }

    @ParameterizedTest(name = "당첨 번호 입력값이 {0}이면 파싱 성공")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1,2,3,4,5,6"})
    @DisplayName("당첨 번호 입력값 파싱 성공")
    void parseWinningNumbers_Success(String input) {
        // given
        final List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        // when
        var result = InputParser.parseWinningNumbers(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}