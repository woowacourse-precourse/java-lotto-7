package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchasedLottosTests {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = WinningLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(7));
    }

    @Test
    void testCalculateRankCountsReturnsCorrectRankCounts() {
        PurchasedLottos purchasedLottos = PurchasedLottos.of(List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                Lotto.from(List.of(1, 2, 3, 4, 5, 7)),  // 2등
                Lotto.from(List.of(1, 2, 3, 4, 5, 8)),  // 3등
                Lotto.from(List.of(1, 2, 3, 4, 8, 9)),  // 4등
                Lotto.from(List.of(1, 2, 3, 8, 9, 10))  // 5등
        ));

        EnumMap<LottoRank, Integer> rankCounts = purchasedLottos.calculateRankCounts(winningLotto);

        assertThat(rankCounts.get(LottoRank.FIRST)).isEqualTo(1);  // 1등 1개
        assertThat(rankCounts.get(LottoRank.SECOND)).isEqualTo(1); // 2등 1개
        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(1);  // 3등 1개
        assertThat(rankCounts.get(LottoRank.FOURTH)).isEqualTo(1); // 4등 1개
        assertThat(rankCounts.get(LottoRank.FIFTH)).isEqualTo(1);  // 5등 없음
        assertThat(rankCounts.get(LottoRank.NONE)).isEqualTo(0);  // 당첨되지 않은 로또 없음
    }

    @Test
    void testCalculateRankCountsReturnsZeroForNoMatches() {
        PurchasedLottos purchasedLottos = PurchasedLottos.of(List.of(
                Lotto.from(List.of(7, 8, 9, 10, 11, 12)),
                Lotto.from(List.of(13, 14, 15, 16, 17, 18))
        ));

        EnumMap<LottoRank, Integer> rankCounts = purchasedLottos.calculateRankCounts(winningLotto);

        assertThat(rankCounts.get(LottoRank.FIRST)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.SECOND)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.NONE)).isEqualTo(2);
    }
}