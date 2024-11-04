package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.enums.Rank;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    private UserLottoService userLottoService;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        userLottoService = new UserLottoService();
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
    }

    @Test
    @DisplayName("6개 일치하는 경우 1등이다")
    void matchSix() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Map<Rank, Integer> statistics = userLottoService.calculateWinningStatistics(
            List.of(lotto), winningNumbers, bonusNumber);

        assertThat(statistics.get(Rank.SIX)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호가 일치하는 경우 2등이다")
    void matchFiveAndBonus() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Map<Rank, Integer> statistics = userLottoService.calculateWinningStatistics(
            List.of(lotto), winningNumbers, bonusNumber);

        assertThat(statistics.get(Rank.FIVE_AND_BONUS)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개만 일치하는 경우 3등이다")
    void matchFive() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Map<Rank, Integer> statistics = userLottoService.calculateWinningStatistics(
            List.of(lotto), winningNumbers, bonusNumber);

        assertThat(statistics.get(Rank.FIVE)).isEqualTo(1);
    }

    @Test
    @DisplayName("여러 개의 로또에 대한 당첨 통계를 정확히 계산한다")
    void calculateMultipleLottos() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1등
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 2등
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),  // 3등
            new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)),  // 4등
            new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9))   // 3등
        );

        Map<Rank, Integer> statistics = userLottoService.calculateWinningStatistics(
            lottos, winningNumbers, bonusNumber);

        assertThat(statistics)
            .containsEntry(Rank.SIX, 1)
            .containsEntry(Rank.FIVE_AND_BONUS, 1)
            .containsEntry(Rank.FIVE, 1)
            .containsEntry(Rank.FOUR, 1)
            .containsEntry(Rank.THREE, 1);
    }

    @Test
    @DisplayName("당첨금 총액을 정확히 계산한다")
    void calculateTotalPrize() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1등
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))   // 2등
        );

        Map<Rank, Integer> statistics = userLottoService.calculateWinningStatistics(
            lottos, winningNumbers, bonusNumber);
        int totalPrize = userLottoService.calculateTotalPrize(statistics);

        assertThat(totalPrize).isEqualTo(2_000_000_000 + 1_500_000);
    }
}