package lotto;

import lotto.model.LottoMatchState;
import lotto.model.Stats;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatsTest {
    private Stats stats = new Stats();

    @Test
    void 당첨_상세_정보_초기화_확인() {
        Map<LottoMatchState, Integer> winningDetail = stats.getWinningDetail();

        assertThat(winningDetail).isEmpty();
    }

    @Test
    void 수익률_계산() {
        stats.addWinningCount(LottoMatchState.SIX);

        double profitRate = stats.getProfitRate(Constant.LOTTO_PRICE);
        assertThat(profitRate).isEqualTo(2000000000.0 / Constant.LOTTO_PRICE * 100);
    }
}
