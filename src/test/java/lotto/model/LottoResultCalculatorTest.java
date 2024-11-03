package lotto.model;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {

    private LottoResultCalculator resultCalculator;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        resultCalculator = new LottoResultCalculator(winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호가 일치하지 않을 때 NONE 반환")
    void whenNoMatch_returnNoneRank() {
        Lotto ticket = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        Map<LottoRank, Integer> results = resultCalculator.calculateResults(List.of(ticket));

        assertThat(results.getOrDefault(LottoRank.NONE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호 일치 시 2등 반환")
    void whenFiveMatchesAndBonusMatches_returnSecondRank() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Map<LottoRank, Integer> results = resultCalculator.calculateResults(List.of(ticket));

        assertThat(results.getOrDefault(LottoRank.SECOND, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호 일치 시 3등 반환")
    void whenFiveMatchesWithoutBonus_returnThirdRank() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Map<LottoRank, Integer> results = resultCalculator.calculateResults(List.of(ticket));

        assertThat(results.getOrDefault(LottoRank.THIRD, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("6개 번호 일치 시 1등 반환")
    void whenAllSixMatches_returnFirstRank() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Map<LottoRank, Integer> results = resultCalculator.calculateResults(List.of(ticket));

        assertThat(results.getOrDefault(LottoRank.FIRST, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("여러 로또 티켓의 당첨 결과 계산")
    void calculateResults_multipleTickets() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 12, 13, 14))
        );

        Map<LottoRank, Integer> results = resultCalculator.calculateResults(tickets);

        assertThat(results.getOrDefault(LottoRank.FIRST, 0)).isEqualTo(1);
        assertThat(results.getOrDefault(LottoRank.SECOND, 0)).isEqualTo(1);
        assertThat(results.getOrDefault(LottoRank.THIRD, 0)).isEqualTo(1);
        assertThat(results.getOrDefault(LottoRank.FOURTH, 0)).isEqualTo(1);
        assertThat(results.getOrDefault(LottoRank.FIFTH, 0)).isEqualTo(1);
    }
}