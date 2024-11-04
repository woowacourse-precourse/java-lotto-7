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

    @Test
    @DisplayName("로또 결과 계산 및 수익률 확인")
    void calculateResultAndProfitRate() {
        LottoTickets tickets = LottoTickets.from(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        ));
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("7", winningNumbers);

        LottoResultDto result = lottoService.calculateResult(tickets, winningNumbers, bonusNumber);

        assertEquals(1, result.getRankCounts().get(Rank.SIX));
        assertEquals(1, result.getRankCounts().get(Rank.FIVE));
        assertTrue(result.getProfitRate() > 0);
    }

    @Test
    @DisplayName("로또 결과 계산 시 유효한 티켓과 당첨 번호 확인")
    void calculateResultWithInvalidTickets() {
        LottoTickets tickets = LottoTickets.from(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        ));
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("7", winningNumbers);

        LottoResultDto result = lottoService.calculateResult(tickets, winningNumbers, bonusNumber);

        assertEquals(0, result.getRankCounts().get(Rank.SIX));
        assertEquals(1, result.getRankCounts().get(Rank.FIVE));
    }
}