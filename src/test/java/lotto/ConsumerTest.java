package lotto;

import lotto.domain.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsumerTest {

    @DisplayName("로또 구매액이 정상")
    @Test
    void 로또_구매액_정상() {
        //given
        int money = 1000;

        //when & then
        assertDoesNotThrow(() ->
                new Consumer(money));
    }


    @DisplayName("로또 구매액이 1000원이 넘지 않는 경우")
    @Test
    void 로또_구매액이_1000원미만() {
        //given
        int money = 900;

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                new Consumer(money));

        //then
        assertEquals("[ERROR] 로또 구매 금액은 1000원 이상이여야 합니다.", throwable.getMessage());
    }

    @DisplayName("로또 구매액이 10만원이 넘는 경우")
    @Test
    void 로또_구매액이_10만원이상() {
        //given
        int money = 100900;

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                new Consumer(money));

        //then
        assertEquals("[ERROR] 로또 구매 금액은 1인당 10만원 이하로 구매 가능합니다.", throwable.getMessage());
    }

}