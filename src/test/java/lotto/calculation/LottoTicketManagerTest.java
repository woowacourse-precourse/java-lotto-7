package lotto.calculation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketManagerTest {

    private LottoTicketManager lottoTicketManager;

    @BeforeEach
    void setUp() {
        lottoTicketManager= new LottoTicketManager();
    }
    @Test
    public void testTicketCount() {
        assertEquals(5, lottoTicketManager.calculateTicketCount(5000));
        assertEquals(1, lottoTicketManager.calculateTicketCount(1000));
    }

}