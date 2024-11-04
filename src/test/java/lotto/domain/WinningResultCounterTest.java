package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultCounterTest {

    @Test
    void 초기화된_당첨_결과는_모두_0이다() {
        WinningResultCounter counter = new WinningResultCounter();
        Map<WinningResult, Integer> result = counter.getWinningResult();
        assertThat(result.values()).allMatch(count -> count == 0);
    }

    @Test
    void 당첨_결과를_증가시킨다() {
        WinningResultCounter counter = new WinningResultCounter();
        counter.increment(WinningResult.RANK_5TH);
        counter.increment(WinningResult.RANK_5TH);
        counter.increment(WinningResult.RANK_4TH);

        Map<WinningResult, Integer> result = counter.getWinningResult();
        assertThat(result.get(WinningResult.RANK_5TH)).isEqualTo(2);
        assertThat(result.get(WinningResult.RANK_4TH)).isEqualTo(1);
    }

    @Test
    void 당첨_결과를_여러_번_증가시킨다() {
        WinningResultCounter counter = new WinningResultCounter();
        counter.increment(WinningResult.RANK_5TH);
        counter.increment(WinningResult.RANK_5TH);
        counter.increment(WinningResult.RANK_5TH);
        counter.increment(WinningResult.RANK_4TH);
        counter.increment(WinningResult.RANK_4TH);

        Map<WinningResult, Integer> result = counter.getWinningResult();
        assertThat(result.get(WinningResult.RANK_5TH)).isEqualTo(3);
        assertThat(result.get(WinningResult.RANK_4TH)).isEqualTo(2);
    }
}