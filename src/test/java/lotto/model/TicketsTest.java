package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketsTest {
    private static final int UNIT = 1000;

    @DisplayName("기능 테스트: 로또 티켓 묶음 생성 확인")
    @Test
    void generate_tickets() {
        int randomValue = Randoms.pickNumberInRange(UNIT, Integer.MAX_VALUE - 1);
        int actualAmount = (randomValue / UNIT) * UNIT;
        int expectedSize = actualAmount / UNIT;

        Tickets tickets = new Tickets(actualAmount);
        List<Lotto> generatedTickets = tickets.getTickets();

        assertEquals(generatedTickets.size(), expectedSize);
    }
}