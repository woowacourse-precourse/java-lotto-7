package lotto.validator;

import static lotto.exception.ExceptionErrorMessage.INPUT_BLANK_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.INPUT_MINUS_NUMBER_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.INPUT_NOT_DIGIT_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.INPUT_ZERO_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputPurchaseAmountValidatorTest {
    private InputPurchaseAmountValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new InputPurchaseAmountValidator();
    }

    @Test
    public void 구매_금액_공백_입력_테스트() {
        String input = "   ";
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_BLANK_MESSAGE.toString());
    }

    @Test
    public void 구매_금액_음수_입력_테스트() {
        String input = "-100";
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MINUS_NUMBER_MESSAGE.toString());
    }

    @Test
    public void 구매_금액_0_입력_테스트() {
        String input = "0";
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_ZERO_NUMBER_MESSAGE.toString());
    }

    @Test
    public void 구매_금액_숫자가_아닌_문자_입력_테스트() {
        String input = "a1000";
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_NOT_DIGIT_MESSAGE.toString());
    }

    @Test
    public void null_입력_테스트() {
        assertThat(validator.isBlank(null)).isTrue();
    }
}