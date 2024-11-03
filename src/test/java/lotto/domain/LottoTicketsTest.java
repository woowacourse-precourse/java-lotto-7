package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    private List<Lotto> generatedLottos;

    @BeforeEach
    void setUp() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        generatedLottos = lottoGenerator.generateLottos(2);
    }

    @DisplayName("구입한 로또 티켓수를 반환한다.")
    @Test
    void getLottoTicketsCount() {
        LottoTickets lottoTickets = new LottoTickets(generatedLottos);

        int ticketCount = lottoTickets.getLottoTicketCount();

        assertEquals(2, ticketCount);
    }

    @DisplayName("구입한 로또 티켓들을 반환한다.")
    @Test
    void getLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(generatedLottos);

        List<Lotto> retrievedTickets = lottoTickets.getLottoTickets();

        assertEquals(generatedLottos, retrievedTickets);
    }
}
