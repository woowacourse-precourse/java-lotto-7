package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    void issueLottoTickets() {
        // Arrange
        LottoService lottoService = new LottoService();
        int ticketCount = 5;

        // Act
        lottoService.issueLottoTickets(ticketCount);

        // Assert
        assertEquals(ticketCount, lottoService.getLottoTickets().size());
    }

    @Test
    void setWinningNumbers() {
        // Arrange
        LottoService lottoService = new LottoService();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // Act
        lottoService.setWinningNumbers(winningNumbers, bonusNumber);

        // Assert
        WinningLotto winningLotto = lottoService.getWinningLotto(); // WinningLotto를 반환하는 메서드 추가 필요
        assertEquals(winningNumbers, winningLotto.getWinningLotto().getNumbers());
        assertEquals(bonusNumber, winningLotto.getBonusNumber());
    }

    @Test
    void calculateResults() {
        // Arrange
        LottoService lottoService = new LottoService();
        lottoService.issueLottoTickets(5); // 로또 티켓 발행
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoService.setWinningNumbers(winningNumbers, bonusNumber);

        // Act
        List<Rank> results = lottoService.calculateResults();

        // Assert
        assertNotNull(results);
        assertEquals(5, results.size());
    }

    @Test
    void calculateYield() {
        // Arrange
        LottoService lottoService = new LottoService();
        lottoService.issueLottoTickets(5); // 로또 티켓 발행
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoService.setWinningNumbers(winningNumbers, bonusNumber);

        // Act
        List<Rank> results = lottoService.calculateResults();
        double yield = lottoService.calculateYield(5000, results); // 예시 금액

        // Assert
        assertTrue(yield >= 0);
    }

    @Test
    void getLottoTickets() {
        // Arrange
        LottoService lottoService = new LottoService();
        lottoService.issueLottoTickets(3); // 로또 티켓 발행

        // Act
        List<Lotto> tickets = lottoService.getLottoTickets();

        // Assert
        assertEquals(3, tickets.size());
    }
}
