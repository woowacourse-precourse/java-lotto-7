package lotto.util;

import org.junit.jupiter.api.Test;

import static lotto.constants.LottoErrorMessage.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputJackpotNumbersValidatorTest {

    final InputJackpotNumbersValidator validator = new InputJackpotNumbersValidator();

    @Test
    void notNumberTest() {
        //given
        String input = "숫자가아님";
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    void sizeTest() {
        // given
        String input = "1,2,3,4,5,6,7";
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_SIZE.getMessage());
    }

    @Test
    void duplicateTest() {
        // given
        String input = "1,2,3,4,5,5";
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_INPUT_NUMBER.getMessage());
    }

    @Test
    void rangeTest() {
        // given
        String input = "1,12,3,4,5,46";
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE.getMessage());
    }
}