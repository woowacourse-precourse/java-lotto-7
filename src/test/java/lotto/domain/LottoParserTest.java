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
        LottoParser lottoParser1 = new LottoParser(input1);
        LottoParser lottoParser2 = new LottoParser(input2);

        // when
        Throwable exception1 = assertThrows(IllegalArgumentException.class, () -> {
            lottoParser1.parse();
        });
        Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> {
            lottoParser2.parse();
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
        LottoParser lottoParser = new LottoParser(input);

        // when
        Lotto lotto = lottoParser.parse();

        // then
        for(int i = 1; i <= 6; i ++) {
            assertTrue(lotto.containNumber(i));
        }
    }
}
