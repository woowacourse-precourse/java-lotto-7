package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constants.LottoConstants;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketGeneratorTest {

    private LottoTicketGenerator ticketGenerator;

    @BeforeEach
    void setUp() {
        ticketGenerator = new LottoTicketGenerator();
    }

    @Test
    @DisplayName("구매 금액에 따른 로또 티켓 생성 개수 확인")
    void createTickets_ShouldGenerateCorrectNumberOfTickets() {
        int purchaseAmount = 5000; // 5000원 구매
        List<Lotto> tickets = ticketGenerator.createTickets(purchaseAmount);

        assertThat(tickets).hasSize(purchaseAmount / LottoConstants.LOTTO_PRICE); // 생성된 티켓 수 확인
    }

    @Test
    @DisplayName("로또 티켓에 숫자 개수 확인")
    void createTickets_ShouldGenerateValidLottoTickets() {
        int purchaseAmount = 3000; // 3000원 구매
        List<Lotto> tickets = ticketGenerator.createTickets(purchaseAmount);

        for (Lotto ticket : tickets) {
            assertThat(ticket.getNumbers()).hasSize(LottoConstants.LOTTO_NUMBER_COUNT); // 각 티켓이 6개의 숫자를 가져야 함
        }
    }

    @Test
    @DisplayName("구매 금액이 0일 때 티켓 생성 확인")
    void createTickets_ShouldReturnEmptyList_WhenPurchaseAmountIsZero() {
        int purchaseAmount = 0; // 0원 구매
        List<Lotto> tickets = ticketGenerator.createTickets(purchaseAmount);

        assertThat(tickets).isEmpty(); // 생성된 티켓 리스트가 비어 있어야 함
    }

}
