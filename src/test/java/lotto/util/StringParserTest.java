package lotto.util;

import lotto.constants.LottoErrorMessage;
import org.junit.jupiter.api.Test;

import static lotto.constants.LottoErrorMessage.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringParserTest {

    @Test
    void toIntTest() {
        // given
        String input = "2222222222222222222222222";
        // when & then
        assertThatThrownBy(() -> StringParser.toInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    void toIntListTest() {
        // given
        String input = "숫자가 아님";
        // when & then
        assertThatThrownBy(() -> StringParser.toIntList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }
}