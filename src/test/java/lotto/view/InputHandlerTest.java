package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

class InputHandlerTest {
    @NullSource
    @ParameterizedTest
    @CsvSource(value = {"'     '", "''", "pobi"})
    void 숫자가_입력되지_않은_경우_예외처리(String input) {
        final InputHandler inputHandler = new InputHandler();

        assertThatThrownBy(() -> inputHandler.validateNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }
}