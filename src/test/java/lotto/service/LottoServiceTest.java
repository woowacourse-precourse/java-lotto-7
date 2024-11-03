package lotto.service;

import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketsDto;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("유효한 금액으로 로또 티켓 구매")
    void purchaseLottoTickets() {
        int amount = 5000;
        List<LottoTicketsDto> tickets = lottoService.purchaseLottoTickets(amount);

        assertEquals(5, tickets.size());
        for (LottoTicketsDto ticket : tickets) {
            assertEquals(6, ticket.getNumbers().size());
            assertTrue(ticket.getNumbers().stream().allMatch(num -> num >= 1 && num <= 45));
        }
    }

}