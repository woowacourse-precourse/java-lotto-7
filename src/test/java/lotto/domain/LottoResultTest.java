package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("각 로또 순위에 맞는 당첨 통계를 계산한다")
    @Test
    void 로또_결과_통계를_계산한다() {
        LottoResult result = new LottoResult();
        result.addResult(LottoRank.FIRST);
        result.addResult(LottoRank.FIRST);
        result.addResult(LottoRank.FIRST);
        result.addResult(LottoRank.SECOND);
        result.addResult(LottoRank.SECOND);
        result.addResult(LottoRank.THIRD);
        result.addResult(LottoRank.THIRD);
        result.addResult(LottoRank.FOURTH);

        Map<LottoRank, Integer> results = result.getResults();
        assertThat(results.get(LottoRank.FIRST)).isEqualTo(3);
        assertThat(results.get(LottoRank.SECOND)).isEqualTo(2);
        assertThat(results.get(LottoRank.THIRD)).isEqualTo(2);
        assertThat(results.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(results.get(LottoRank.FIFTH)).isNull();
    }
}