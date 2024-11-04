package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.dto.WinningResultDto;
import lotto.wrapper.BonusNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningServiceTest {

    private WinningService winningService;
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningService = new WinningService();
        lottos = Lottos.of(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)),
                new Lotto(Arrays.asList(1, 2, 40, 41, 42, 43)),
                new Lotto(Arrays.asList(1, 2, 40, 41, 43, 44))
        ));
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLotto = WinningLotto.of(winningNumbers, BonusNumber.of(7));
    }

    @DisplayName("로또 당첨 결과를 올바르게 계산한다")
    @Test
    void 로또_당첨_결과_반환_테스트() {
        // Expected
        Map<Rank, Integer> expectedPrizeCounts = new EnumMap<>(Rank.class);
        expectedPrizeCounts.put(Rank.SIX_MATCHES, 2);
        expectedPrizeCounts.put(Rank.FIVE_MATCHES_WITH_BONUS, 3);
        expectedPrizeCounts.put(Rank.FIVE_MATCHES, 1);
        expectedPrizeCounts.put(Rank.FOUR_MATCHES, 1);
        expectedPrizeCounts.put(Rank.THREE_MATCHES, 0);
        expectedPrizeCounts.put(Rank.NO_MATCH, 2);

        BigDecimal expectedProfitRate = BigDecimal.valueOf(2_000_000_000L * 2 + 30_000_000 * 3 + 1_500_000 + 50_000)
                .divide(BigDecimal.valueOf(9), 2, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(10), 2, RoundingMode.HALF_UP);

        WinningResultDto result = winningService.calculateWinningResult(lottos, winningLotto);

        Assertions.assertThat(result.rankCounts()).isEqualTo(expectedPrizeCounts);
        Assertions.assertThat(result.profitRate()).isEqualTo(expectedProfitRate);
    }
}
