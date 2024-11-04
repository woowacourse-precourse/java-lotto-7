package lotto.service;

import lotto.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoRank;
import lotto.model.strategy.FixedNumberGeneration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(new LottoMachine(new FixedNumberGeneration()));
    }

    @Test
    @DisplayName("구입 금액에 따라 올바른 개수의 로또 티켓이 발행된다.")
    void testPurchaseLottoTickets() {
        int amount = 5000;
        List<Lotto> tickets = lottoService.purchaseLottoTickets(amount);

        assertThat(tickets).hasSize(amount / 1000);
        tickets.forEach(ticket -> assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨 결과가 올바르게 계산된다.")
    void testCalculateResults() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9))
        );

        Map<LottoRank, Integer> results = lottoService.calculateResults(tickets, List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(results.getOrDefault(LottoRank.FIRST, 0)).isEqualTo(1);
        assertThat(results.getOrDefault(LottoRank.SECOND, 0)).isEqualTo(1);
        assertThat(results.getOrDefault(LottoRank.FOURTH, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률이 올바르게 계산된다.")
    void testCalculateYield() {
        Map<LottoRank, Integer> results = Map.of(
                LottoRank.FIRST, 1,
                LottoRank.SECOND, 0,
                LottoRank.THIRD, 0,
                LottoRank.FOURTH, 0,
                LottoRank.FIFTH, 0
        );

        double yield = lottoService.calculateYield(1000, results);
        assertThat(yield).isEqualTo(200000000.0);
    }

    @Test
    @DisplayName("모든 로또 티켓이 하나도 당첨되지 않았을 때 NONE이 반환된다")
    void testCalculateYieldNone() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),
                new Lotto(List.of(14, 15, 16, 17, 18, 19))
        );
        Map<LottoRank, Integer> results = lottoService.calculateResults(tickets, List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(results.getOrDefault(LottoRank.NONE, 0)).isEqualTo(2);
        assertThat(results.values().stream().filter(count -> count > 0).count()).isEqualTo(1);
    }

    @Test
    @DisplayName("다양한 당첨 티켓의 수익률이 올바르게 계산된다")
    void testCalculateYieldExactly() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 12, 13, 14))
        );
        Map<LottoRank, Integer> results = lottoService.calculateResults(tickets, List.of(1, 2, 3, 4, 5, 6), 7);
        double yield = lottoService.calculateYield(5000, results);

        assertThat(yield).isGreaterThan(0);
    }
}