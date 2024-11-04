package lotto.domain;

import lotto.Lotto;
import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("정확한 Input을 입력했을 때 해당 개수만큼의 Lotto가 발급되는지 확인")
    void generateLottoTest() {
        // given
        String input = "2000";

        // when
        LottoFactory lottoFactory = new LottoFactory(input);
        List<Lotto> lottos = lottoFactory.generate();

        // when
        assertEquals(lottos.size(), 2);
    }

    @Test
    @DisplayName("null이 들어왔을 때 validateCount() 함수가 호출되지 않아야 함")
    void checkNumberParseErrorWhenNullInput() {
        // given
        String input = null;

        // given
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoFactory(input);
        });

        //then
        assertEquals(exception.getMessage(), ErrorMessage.numberParseError);
    }

    @Test
    @DisplayName("1000으로 나눠지지 않을 때 cantDividedInto1000 Error 발생확인")
    void checkCantDividedInto1000ErrorWhenNotDividedBy1000() {
        // given
        String input = "1001";

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoFactory(input);
        });

        // then
        assertEquals(exception.getMessage(), ErrorMessage.cantDividedInto1000);
    }
}
