package lotto.domain;

import lotto.constant.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("입력받은 Ranking에 해당하는 값을 1만큼 증가시킨다.")
    void increase() {
        // given
        Map<Ranking, Integer> elements = new EnumMap<>(Ranking.class);
        LottoResult lottoResult = new LottoResult(elements);
        // when
        lottoResult.increaseCount(Ranking.FIRST);
        // then
        assertThat(elements.get(Ranking.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 상금 / 구매 금액 * 100 식으로 수익률을 계산한다.")
    void getRateOfReturn() {
        // given
        Map<Ranking, Integer> elements = new EnumMap<>(Ranking.class);
        elements.put(Ranking.FIRST, 1);
        elements.put(Ranking.NONE, 9);
        LottoResult lottoResult = new LottoResult(elements);
        // when
        double result = lottoResult.getRateOfReturn();
        // then
        assertThat(String.format("%.1f", result)).isEqualTo("20000000.0");
    }
}