package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottosCreatorTest {
    @Test
    void 로또구매금액이1000원단위가아닌경우() {
        // given
        LottosCreator lottosCreator = new LottosCreator();
        int purchase = 1001;
        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> lottosCreator.createLottos(purchase));
    }

}