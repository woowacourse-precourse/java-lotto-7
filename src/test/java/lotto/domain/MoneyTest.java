package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
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

    @Test
    void 수익률_구하기_테스트() {
        //given
        Money money = new Money(8000);
        LinkedHashMap<Rank, Integer> result = new LinkedHashMap<>();
        result.put(Rank.FIFTH, 1);

        //when
        String rateOfReturn = money.getRateOfReturn(result);

        //then
        assertEquals(rateOfReturn, "62.5");
    }

    @Test
    void BigDecimal_수익률_구하기_테스트() {
        //given
        Money money = new Money(1000000000);
        LinkedHashMap<Rank, Integer> result = new LinkedHashMap<>();
        result.put(Rank.FIRST, 3);

        //when
        String rateOfReturn = money.getRateOfReturn(result);

        //then
        assertEquals(rateOfReturn, "600.0");
    }
}