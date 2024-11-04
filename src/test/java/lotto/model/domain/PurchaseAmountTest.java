package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    void 구매_금액_생성_성공() {
        //given
        int amount = 10000;

        //then
        assertDoesNotThrow(() -> new PurchaseAmount(amount));
    }

    @Test
    void 구매_금액_단위_검증_실패() {
        //given
        int amount = 10090;

        //then
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount));
    }

    @Test
    void 최대_구매_금액_검증_실패() {
        //given
        int amount = 100010;

        //then
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount));
    }

    @Test
    void 최소_구매_금액_검증_실패() {
        //given
        int amount = 100;

        //then
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount));
    }


}