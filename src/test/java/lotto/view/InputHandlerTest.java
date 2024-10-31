package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

class InputHandlerTest {
    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }

    @NullSource
    @ParameterizedTest
    @CsvSource(value = {"'     '", "''", "pobi"})
    void 숫자가_입력되지_않은_경우_예외처리(String input) {
        assertThatThrownBy(() -> inputHandler.validateNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @NullSource
    @ParameterizedTest
    @DisplayName("null이 입력되면 예외처리")
    void testCheckNull(String input) {
        assertThatThrownBy(() -> inputHandler.checkNull(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자의 범위가 1~45가 아니면 예외처리")
    @CsvSource(value = {"0","46"})
    void testCheckNumberRange(int number) {
        assertThatThrownBy(() -> inputHandler.checkNumberRange(number)).isInstanceOf(IllegalArgumentException.class);
    }
}