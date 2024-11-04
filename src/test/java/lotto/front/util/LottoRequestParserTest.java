package lotto.front.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.assertj.core.api.Assertions;
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

    @Test
    void 로또_번호_파싱() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<Integer> prizeNumbers = LottoRequestParser.parsePrizeNumber(input);

        // then
        Assertions.assertThat(prizeNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_번호_파싱_예외() {
        // given
        String input = "1,2,3,4,5,6,,7";

        // when, then
        assertThatThrownBy(() -> LottoRequestParser.parsePrizeNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_파싱() {
        // given
        String input = "7";

        // when
        int bonusNumber = LottoRequestParser.parseBonusNumber(input);

        // then
        assertEquals(7, bonusNumber);
    }

    @Test
    void 보너스_번호_파싱_예외() {
        // given
        String input = "7j";

        // when, then
        assertThatThrownBy(() -> LottoRequestParser.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}