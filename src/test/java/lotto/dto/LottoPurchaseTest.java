package lotto.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

    @Test
    void 입력_2000원_티켓_2장() {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase(2000);
        //when
        int ticketNumber = lottoPurchase.getTicketNumber();

        //then
        assertEquals(2, ticketNumber);
    }

    @Test
    void _1000의_배수가_아닌_경우() {
        // given
        int amount = 2500;  // An invalid amount that is not a multiple of 1000

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new LottoPurchase(amount));
    }
}