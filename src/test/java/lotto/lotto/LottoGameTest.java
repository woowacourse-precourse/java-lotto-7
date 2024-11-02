package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;

class LottoGameTest {

    @Test
    void 수익률을_계산한다() {
        // given
        LottoGame lottoGame = new LottoGame();

        Map<Rank, Integer> rankSummary = Map.of(
            Rank.FIRST, 0,
            Rank.SECOND, 0,
            Rank.THIRD, 0,
            Rank.FOURTH, 0,
            Rank.FIFTH, 1
        );
        LottoAmount lottoAmount = new LottoAmount(8000);

        // when
        double profit = lottoGame.calculateProfit(rankSummary, lottoAmount);

        // then
        assertThat(profit).isEqualTo(62.5);
    }
}
