package lotto.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketMakerTest {

    @Test
    @DisplayName("단위에 맞는 금액을 입력하면 티켓 갯수를 정상적으로 구한다")
    void run_when_price_is_correct_unit() {
        int price = 3000;

        Assertions.assertEquals(TicketMaker.make(price), 3);
    }
}
