package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class JackpotNumbersValidatorTest {

    final JackpotNumbersValidator validator = new JackpotNumbersValidator();

    @Test
    void notNumberTest() {
        //given
        String input = "숫자가아님";
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}