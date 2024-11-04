package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class WinningResultTest {

    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult();
    }

    @Test
    void 초기화된_당첨_결과는_모든_등수가_0이다() {
        // given & when & then
        for (Rank rank : Rank.values()) {
            assertThat(winningResult.getCount(rank)).isZero();
        }
    }

    @Test
    void 특정_등수의_당첨_횟수를_추가할_수_있다() {
        // given
        Rank rank = Rank.THIRD;

        // when
        winningResult.addResult(rank);
        winningResult.addResult(rank);

        // then
        assertThat(winningResult.getCount(rank)).isEqualTo(2);
    }

    @Test
    void 특정_등수의_당첨_횟수를_정확히_반환한다() {
        // given
        Rank rank = Rank.FIFTH;
        winningResult.addResult(rank);

        // when
        int count = winningResult.getCount(rank);

        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    void 총_수익률을_계산할_수_있다() {
        // given
        int totalAmount = 10000;
        winningResult.addResult(Rank.THIRD);
        winningResult.addResult(Rank.FIFTH);

        // when
        double totalReturn = winningResult.calculateTotalReturn(totalAmount);
        int totalPrize = Rank.THIRD.getPrize() + Rank.FIFTH.getPrize();
        double expectedReturn = (totalPrize / (double) totalAmount) * 100;

        // then
        assertThat(totalReturn).isCloseTo(expectedReturn, within(0.01));
    }
}
