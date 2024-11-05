package lotto.domain;

import lotto.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.LottoConstants.PRICE_PER_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @DisplayName("당첨 횟수가 올바르게 증가한다")
    @Test
    void 당첨_횟수_증가_테스트() {
        lottoResult.recordMatch(Rank.SIX_MATCH);
        lottoResult.recordMatch(Rank.SIX_MATCH);
        lottoResult.recordMatch(Rank.FIVE_MATCH);

        assertThat(lottoResult.getWinningCount().get(Rank.SIX_MATCH)).isEqualTo(2);
        assertThat(lottoResult.getWinningCount().get(Rank.FIVE_MATCH)).isEqualTo(1);
    }

    @DisplayName("구입 금액 대비 수익률을 올바르게 계산한다")
    @Test
    void 수익률_계산_테스트() {
        lottoResult.recordMatch(Rank.SIX_MATCH);

        int buyCount = 10;
        lottoResult.calculateProfitRate(buyCount);

        double expectedProfitRate = (double) Rank.SIX_MATCH.getWinnings() / (buyCount * PRICE_PER_LOTTO) * 100;
        assertThat(lottoResult.getProfitRate()).isEqualTo(expectedProfitRate);
    }
}
