package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningTierManagerTest {
    LottoWinningTierManager lottoWinningTierManager;
    @BeforeEach
    void setUp () {
        lottoWinningTierManager = new LottoWinningTierManager();
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.NONE, 2);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_THREE, 1);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_FOUR, 1);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_FIVE, 3);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_FIVE_WITH_BONUS, 2);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_SIX, 1);
    }
    @Test
    void 당첨_금액_합을_리턴() {
        // given
        // when
        long sumResult = lottoWinningTierManager.calculateTotalPrize();

        // then
        assertThat(sumResult).isEqualTo(2064555000);
    }

    @Test
    void 로또_당첨_개수_증가() {
        // given
        // when
        lottoWinningTierManager.increaseLottoWinningTier(
                LottoWinningTier.MATCH_SIX.getMatchCount(), false);

        // then
        assertThat(lottoWinningTierManager.getWinningTierCount(LottoWinningTier.MATCH_SIX)).isEqualTo(2);
    }
}
