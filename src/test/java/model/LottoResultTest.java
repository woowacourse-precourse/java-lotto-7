package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("당첨 통계를 올바르게 계산한다")
    void 당첨_통계_계산() {
        List<Prize> prizes = Arrays.asList(
                Prize.FIFTH,
                Prize.FOURTH,
                Prize.THIRD,
                Prize.SECOND,
                Prize.FIRST,
                Prize.MISS
        );

        LottoResult result = new LottoResult(prizes);
        List<Integer> statistics = result.getWinningResult();

        assertThat(statistics).containsExactly(1, 1, 1, 1, 1);
    }

    @Test
    @DisplayName("수익률을 올바르게 계산한다")
    void 수익률_계산() {
        List<Prize> prizes = Arrays.asList(
                Prize.FIFTH,  // 5,000원
                Prize.FIFTH   // 5,000원
        );

        LottoResult result = new LottoResult(prizes);

        assertThat(result.calculateWinningRate()).isEqualTo(500.0);
    }
}

