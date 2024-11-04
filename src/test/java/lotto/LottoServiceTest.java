package lotto;

import lotto.service.LottoService;
import lotto.constant.LottoConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private LottoService lottoService;
    private static final int VALID_PURCHASE_AMOUNT = LottoConstants.TICKET_PRICE * 5;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(VALID_PURCHASE_AMOUNT);
    }

    @Test
    void 로또_티켓이_구매_금액에_맞게_생성된다() {
        List<List<Integer>> tickets = lottoService.generateLottoTickets();
        int expectedTicketCount = VALID_PURCHASE_AMOUNT / LottoConstants.TICKET_PRICE;

        assertThat(tickets).hasSize(expectedTicketCount);
    }
}