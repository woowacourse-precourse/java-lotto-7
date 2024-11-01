package lotto.domain.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TicketCalculatorImplTest {

    @Test
    void 계산_결과_확인() {
        TicketCalculator ticketCalculator = new TicketCalculatorImpl();

        int expected = ticketCalculator.calculate(5000);
        int actual = 5;

        assertEquals(expected, actual);
    }


}