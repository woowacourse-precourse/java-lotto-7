package lotto.validator;

import static lotto.exception.ExceptionErrorMessage.INPUT_BLANK_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.INPUT_MINUS_NUMBER_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.INPUT_NOT_DIGIT_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.INPUT_ZERO_NUMBER_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputBonusNumberValidatorTest {
    private InputBonusNumberValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new InputBonusNumberValidator();
    }

    @Test
    public void 보너스_번호_공백_입력_테스트() {
        String input = "   ";
        assertThatThrownBy(() -> validator.validateBeforeParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_BLANK_MESSAGE.toString());
    }


    @Test
    public void 보너스_번호_음수_입력_테스트() {
        String input = "-1";
        assertThatThrownBy(() -> validator.validateBeforeParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MINUS_NUMBER_MESSAGE.toString());
    }

    @Test
    public void 보너스_번호가_0일_때_입력_테스트() {
        String input = "0";
        assertThatThrownBy(() -> validator.validateBeforeParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_ZERO_NUMBER_MESSAGE.toString());
    }

    @Test
    public void 보너스_번호가_아닌_문자_입력_테스트() {
        String input = "a";
        assertThatThrownBy(() -> validator.validateBeforeParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_NOT_DIGIT_MESSAGE.toString());
    }

    @Test
    public void 보너스_번호가_로또_번호_범위를_벗어났을_때_입력_테스트() {
        int input = 46;
        assertThatThrownBy(() -> validator.validateAfterParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE.toString());
    }

    @Test
    public void null_입력_테스트() {
        assertThat(validator.isBlank(null)).isTrue();
    }
}
