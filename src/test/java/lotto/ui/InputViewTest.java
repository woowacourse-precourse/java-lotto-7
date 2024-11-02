package lotto.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest  {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    void 로또_티켓_발행() {
        int result = inputView.processUserInput("1000");
        assertEquals(1, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1500", "1000j", "0", "-1000"})
    void 유효하지_않은_입력_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> inputView.processUserInput(input));
    }
}