package lotto.service;

import java.math.BigDecimal;
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
        lottos = new Lottos(Arrays.asList(
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
        Map<Rank, Integer> expectedRankCounts = new EnumMap<>(Rank.class);
        expectedRankCounts.put(Rank.SIX_MATCHES, 2);
        expectedRankCounts.put(Rank.FIVE_MATCHES_WITH_BONUS, 3);
        expectedRankCounts.put(Rank.FIVE_MATCHES, 1);
        expectedRankCounts.put(Rank.FOUR_MATCHES, 1);
        expectedRankCounts.put(Rank.THREE_MATCHES, 0);
        expectedRankCounts.put(Rank.NO_MATCH, 2);

        BigDecimal expectedTotalPrize = BigDecimal.valueOf(Rank.SIX_MATCHES.getPrize()).multiply(BigDecimal.valueOf(2))
                .add(BigDecimal.valueOf(Rank.FIVE_MATCHES_WITH_BONUS.getPrize()).multiply(BigDecimal.valueOf(3)))
                .add(BigDecimal.valueOf(Rank.FIVE_MATCHES.getPrize()))
                .add(BigDecimal.valueOf(Rank.FOUR_MATCHES.getPrize()));

        WinningResultDto result = winningService.calculateWinningResult(lottos, winningLotto);

        Assertions.assertThat(result.rankCounts()).isEqualTo(expectedRankCounts);
        Assertions.assertThat(result.totalPrize()).isEqualTo(expectedTotalPrize);
    }
}
