package lotto.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.ErrorMessage;
import lotto.utils.parser.PurchaseAmountParser;
import lotto.utils.validator.PurchaseAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountParserTest {
    private final PurchaseAmountParser parser = new PurchaseAmountParser(new PurchaseAmountValidator());

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

    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234a", "abc"})
    void testNotNumberInput(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 수를 입력하면 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"999", "1234"})
    void testInvalidNumber(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
    }

    @DisplayName("1000보다 작은 수를 입력하면 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000"})
    void testZeroInput(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
    }

    @DisplayName("정상적인 값을 입력하면 정수로 파싱되어야한다.")
    @Test
    void testValidInput() {
        List<String> userInput = List.of("1000", "10000", "100000");
        List<Integer> parsedInput = userInput.stream()
                .map(parser::parse)
                .toList();

        assertThat(parsedInput).hasSize(userInput.size());
        assertThat(parsedInput).containsExactly(1000, 10000, 100000);
    }
}
