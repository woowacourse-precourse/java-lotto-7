package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberStatisticsTest {

    @DisplayName("당첨 번호와 구매한 로또 번호를 비교하여 당첨 내역을 확인한다.")
    @Test
    void checkWinnerTest() {

        LottoNumberStatistics lottoNumberStatistics = new LottoNumberStatistics();
        List<Lotto> lotteryTickets = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
            new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
            new Lotto(List.of(1, 2, 3, 8, 9, 10)) // 미당첨
        );

        HashMap<Integer, String> winnerNumbers = new HashMap<>();
        winnerNumbers.put(1, "winningNumber");
        winnerNumbers.put(2, "winningNumber");
        winnerNumbers.put(3, "winningNumber");
        winnerNumbers.put(4, "winningNumber");
        winnerNumbers.put(5, "winningNumber");
        winnerNumbers.put(6, "winningNumber");
        winnerNumbers.put(7, "bonusNumber");

        HashMap<String, String> results = lottoNumberStatistics.checkWinner(lotteryTickets,
            winnerNumbers);

        assertThat(results.get(LottoRank.MATCH_SIX.name())).isEqualTo("1");
        assertThat(results.get(LottoRank.MATCH_FIVE.name())).isEqualTo("0");
        assertThat(results.get(LottoRank.MATCH_FOUR.name())).isEqualTo("0");
        assertThat(results.get(LottoRank.MATCH_THREE.name())).isEqualTo("1");
        assertThat(results.get(LottoRank.MATCH_FIVE_BONUS.name())).isEqualTo("1");
    }

    @DisplayName("구매한 로또가 당첨되지 않은 경우 통계 확인")
    @Test
    void checkWinnerNoMatchTest() {
        // Given
        LottoNumberStatistics lottoNumberStatistics = new LottoNumberStatistics();
        List<Lotto> lotteryTickets = List.of(
            new Lotto(List.of(10, 11, 12, 13, 14, 15)),
            new Lotto(List.of(16, 17, 18, 19, 20, 21))
        );

        HashMap<Integer, String> winnerNumbers = new HashMap<>();
        winnerNumbers.put(1, "winningNumber");
        winnerNumbers.put(2, "winningNumber");
        winnerNumbers.put(3, "winningNumber");
        winnerNumbers.put(4, "winningNumber");
        winnerNumbers.put(5, "winningNumber");
        winnerNumbers.put(6, "winningNumber");
        winnerNumbers.put(7, "bonusNumber");

        // When
        HashMap<String, String> results = lottoNumberStatistics.checkWinner(lotteryTickets,
            winnerNumbers);

        // Then
        assertThat(results.get(LottoRank.MATCH_SIX.name())).isEqualTo("0");
        assertThat(results.get(LottoRank.MATCH_FIVE.name())).isEqualTo("0");
        assertThat(results.get(LottoRank.MATCH_FOUR.name())).isEqualTo("0");
        assertThat(results.get(LottoRank.MATCH_THREE.name())).isEqualTo("0");
        assertThat(results.get(LottoRank.MATCH_FIVE_BONUS.name())).isEqualTo("0");
    }

    @DisplayName("당첨 통계에서 수익률 계산 확인")
    @Test
    void checkReturnRateCalculation() {
        // Given
        LottoNumberStatistics lottoNumberStatistics = new LottoNumberStatistics();

        List<Lotto> lotteryTickets = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 당첨 (1등)
            new Lotto(List.of(1, 2, 3, 4, 5, 7)) // 당첨 (2등)
            // 총 두 장의 로또 구매
        );

        HashMap<Integer, String> winnerNumbers = new HashMap<>();
        winnerNumbers.put(1, "winningNumber");
        winnerNumbers.put(2, "winningNumber");
        winnerNumbers.put(3, "winningNumber");
        winnerNumbers.put(4, "winningNumber");
        winnerNumbers.put(5, "winningNumber");
        winnerNumbers.put(6, "winningNumber");
        winnerNumbers.put(7, "bonusNumber");

        // When
        HashMap<String, String> results = lottoNumberStatistics.checkWinner(lotteryTickets,
            winnerNumbers);

        // Then: 수익률 계산 확인 (당첨금: 2000000000 + 30000000)
        double expectedReturnRate = (2000000000 + 30000000) / (lotteryTickets.size() * 1000) * 100;
        assertThat(results.get("TOTAL_RETURN_RATE")).isEqualTo(
            String.format("%.1f", expectedReturnRate));
    }
}