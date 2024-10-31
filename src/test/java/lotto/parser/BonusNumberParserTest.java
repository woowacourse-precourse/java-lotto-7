package lotto.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.ErrorMessage;
import lotto.utils.parser.BonusNumberParser;
import lotto.utils.validator.BonusNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberParserTest {
    private final BonusNumberParser parser = new BonusNumberParser(new BonusNumberValidator());
    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 45);
    }

    @DisplayName("빈 문자열 및 공백을 입력하면 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "\n",
            " ",
            "      "
    })
    void testEmptyInput(String input) {
        assertThatThrownBy(() -> parser.parse(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE.toString());
    }

    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234a", "abc"})
    void testNotNumberInput(String input) {
        assertThatThrownBy(() -> parser.parse(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_ERROR_MESSAGE.toString());
    }

    @DisplayName("1부터 45까지의 숫자를 입력하지 않은 경우 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void testNumberInRange(String input) {
        assertThatThrownBy(() -> parser.parse(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_ERROR_MESSAGE.toString());
    }

    @DisplayName("당첨 번호와 중복된 경우 예외가 발생해야한다.")
    @Test
    void testDuplicateWithWinningNumbers() {
        String input = "45";

        assertThatThrownBy(() -> parser.parse(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_ERROR_MESSAGE.toString());
    }

    @DisplayName("정상적인 값을 입력하면 정수로 파싱되어야한다.")
    @Test
    void testValidInput() {
        String input = "25";
        int parsedInput = parser.parse(input, winningNumbers);

        assertThat(parsedInput).isEqualTo(25);
    }
}
