package lotto.front.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LottoRequestParserTest {

    @Test
    void 가격_파싱() {
        // given
        String input = "1000";

        // when
        int result = LottoRequestParser.parsePrice(input);

        // then
        assertEquals(1000, result);
    }

    @Test
    void 가격_파싱_예외() {
        // given
        String input = "1000.0";

        // when, then
        assertThatThrownBy(() -> LottoRequestParser.parsePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}