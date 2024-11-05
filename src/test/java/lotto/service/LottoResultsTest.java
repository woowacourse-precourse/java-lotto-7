package lotto.service;

import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultsTest {
    private final LottoResults lottoResults = new LottoResults();

    @Test
    @DisplayName("로또 결과 계산 및 순위 확인")
    void calculateResultAndRank() {
        LottoTickets tickets = LottoTickets.from(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        ));
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("7", winningNumbers);

        Map<Rank, Integer> result = lottoResults.calculateResult(tickets, winningNumbers, bonusNumber);

        assertEquals(1, result.get(Rank.SIX));
        assertEquals(2, result.get(Rank.FIVE));
        assertEquals(0, result.get(Rank.FOUR));
        assertEquals(0, result.get(Rank.THREE));
        assertEquals(0, result.get(Rank.NONE));
    }

    @Test
    @DisplayName("총 수익 계산 확인")
    void calculateTotalEarnings() {
        LottoTickets tickets = LottoTickets.from(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        ));
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("7", winningNumbers);

        Map<Rank, Integer> result = lottoResults.calculateResult(tickets, winningNumbers, bonusNumber);
        long totalEarnings = lottoResults.calculateTotalEarnings(result);

        assertEquals(2_000_000_000 + 1_500_000, totalEarnings);
    }
}