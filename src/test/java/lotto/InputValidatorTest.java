package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private InputValidator inputValidator;
    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(ints = {14237, 784132, 98745, 1410})
    void 금액이_1000원으로_떨어지지_않으면_예외를_반환한다(int amount) {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAmount(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    void 금액이_0이하이면_예외를_반환한다(int amount) {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAmount(amount);
        });
    }
}