package lotto.domain;

import lotto.Lotto;
import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoParserTest {

    @Test
    @DisplayName("0 이하의 수를 입력했을 때 Exception 발생")
    void testInputZero() {
        // given
        String input1 = "0,1,2,3,4,5";
        String input2 = "1,2,3,4,5, 46";

        // when
        Throwable exception1 = assertThrows(IllegalArgumentException.class, () -> {
            LottoParser.parse(input1);
        });
        Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> {
            LottoParser.parse(input2);
        });

        // then
        assertEquals(exception1.getMessage(), ErrorMessage.lottoNumberOutOfRange);
        assertEquals(exception2.getMessage(), ErrorMessage.lottoNumberOutOfRange);
    }

    @Test
    @DisplayName("파싱 제대로 되는지 테스트")
    void parseTest() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        Lotto lotto = LottoParser.parse(input);

        // then
        for(int i = 1; i <= 6; i ++) {
            assertTrue(lotto.containNumber(i));
        }
    }
}
