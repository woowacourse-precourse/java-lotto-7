package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 구입_매수_구하기_테스트() {
        //given
        Money money = new Money(2000);

        //when
        int ticketCount = money.getTicketCount();

        //then
        Assertions.assertEquals(ticketCount, 2);
    }
}