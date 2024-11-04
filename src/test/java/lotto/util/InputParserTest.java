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
    void parseBudget_EmptyInput_ExceptionThrown() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> InputParser.parseBudget(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
    }

    @Test
    @DisplayName("로또 가격 입력값이 null이면 IllegalArgumentException 발생")
    void parseBudget_NullInput_ExceptionThrown() {
        // given
        String input = null;

        // when, then
        assertThatThrownBy(() -> InputParser.parseBudget(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
    }

    @ValueSource(strings = {"   ", "abc", "1.1"})
    @ParameterizedTest(name = "로또 가격 입력값이 {0}이면 IllegalArgumentException 발생")
    @DisplayName("로또 가격 입력값이 숫자가 아니면 IllegalArgumentException 발생")
    void parseBudget_NotNumberInput_ExceptionThrown(String input) {
        // given

        // when, then
        assertThatThrownBy(() -> InputParser.parseBudget(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }

    @ParameterizedTest(name = "로또 가격 입력값이 {0}이면 파싱 성공")
    @ValueSource(strings = {"1000", "   1000", "    1000    "})
    @DisplayName("로또 입력값 파싱 성공")
    void parseBudget_Success(String input) {
        // given
        final Integer expected = 1000;

        // when
        int result = InputParser.parseBudget(input);

        // then
        assertThat(result).isEqualTo(expected);
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

    @Test
    @DisplayName("보너스 볼 입력값이 비어있으면 IllegalArgumentException 발생")
    void parseBonusNumber_EmptyInput_ExceptionThrown() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> InputParser.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
    }

    @Test
    @DisplayName("보너스 볼 입력값이 null이면 IllegalArgumentException 발생")
    void parseBonusNumber_NullInput_ExceptionThrown() {
        // given
        String input = null;

        // when, then
        assertThatThrownBy(() -> InputParser.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
    }

    @ValueSource(strings = {"   ", "abc", "1.1"})
    @ParameterizedTest(name = "보너스 볼 입력값이 {0}이면 IllegalArgumentException 발생")
    @DisplayName("보너스 볼 입력값이 숫자가 아니면 IllegalArgumentException 발생")
    void parseBonusNumber_NotNumberInput_ExceptionThrown(String input) {
        // given

        // when, then
        assertThatThrownBy(() -> InputParser.parseBonusNumber(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(InputErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }

    @ParameterizedTest(name = "보너스 볼 입력값이 {0}이면 파싱 성공")
    @ValueSource(strings = {"7", "   7", "    7    "})
    @DisplayName("보너스 볼 입력값 파싱 성공")
    void parseBonusNumber_Success(String input) {
        // given
        final Integer expected = 7;

        // when
        int result = InputParser.parseBonusNumber(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 가격 입력값이 음수이면 파싱 성공")
    void parseBudget_NegativeNumberInput_ExceptionThrown() {
        // given
        String input = "-1000";
        final Integer expected = -1000;

        // when, then
        int result = InputParser.parseBudget(input);
    }

    @Test
    @DisplayName("당첨 번호에 음수가 포함되어있으면 파싱 성공")
    void parseWinningNumbers_NegativeNumberInput_ExceptionThrown() {
        // given
        String input = "-1, 2, 3, 4, 5, 6";
        final List<Integer> expected = List.of(-1, 2, 3, 4, 5, 6);

        // when
        var result = InputParser.parseWinningNumbers(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("보너스 볼 입력값이 음수이면 파싱 성공")
    void parseBonusNumber_NegativeNumberInput_ExceptionThrown() {
        // given
        String input = "-7";
        final Integer expected = -7;

        // when
        int result = InputParser.parseBonusNumber(input);
    }
}