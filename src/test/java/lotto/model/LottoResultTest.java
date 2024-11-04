package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @DisplayName("각 등수를 추가할 수 있다.")
    @Test
    void 정상적으로_등수를_추가한다() {
        lottoResult.addWin(1);
        lottoResult.addWin(2);
        lottoResult.addWin(1);

        int[] rankCounts = lottoResult.getRankCounts();

        assertThat(rankCounts[0]).isEqualTo(2); // 1등 횟수
        assertThat(rankCounts[1]).isEqualTo(1); // 2등 횟수
        assertThat(rankCounts[2]).isEqualTo(0); // 3등 횟수
        assertThat(rankCounts[3]).isEqualTo(0); // 4등 횟수
        assertThat(rankCounts[4]).isEqualTo(0); // 5등 횟수
        assertThat(rankCounts[5]).isEqualTo(0); // 꽝 횟수
    }

    @DisplayName("잘못된 등수 추가 시 예외가 발생한다.")
    @Test
    void 잘못된_등수_추가시_예외발생() {
        assertThatThrownBy(() -> lottoResult.addWin(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> lottoResult.addWin(7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("총 상금이 정확하게 계산된다.")
    @Test
    void getTotalPrizeAmount_정확하게_계산된다() {
        lottoResult.addWin(1);
        lottoResult.addWin(2);
        lottoResult.addWin(3);

        long totalPrize = lottoResult.getTotalPrizeAmount();
        long answer = PrizeAmount.FIRST.getPrizeAmount() + PrizeAmount.SECOND.getPrizeAmount() + PrizeAmount.THIRD.getPrizeAmount();
        assertThat(totalPrize).isEqualTo(answer);
    }

    @DisplayName("초기 상태에서 총 상금은 0이다.")
    @Test
    void 초기상태에서_총상금은_0이다() {
        long totalPrize = lottoResult.getTotalPrizeAmount();
        assertThat(totalPrize).isEqualTo(0);
    }
}
