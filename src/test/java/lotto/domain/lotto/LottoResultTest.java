package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 결과 테스트")
class LottoResultTest {

    @Test
    @DisplayName("로또 결과를 추가한다")
    void 성공_로또결과() {
        // Given
        LottoResult lottoResult = new LottoResult();

        // When
        lottoResult.add(LottoRank.FIRST);

        // Then
        assertThat(lottoResult).extracting("result").isEqualTo(new HashMap<>() {{
            put(LottoRank.FIRST, BigDecimal.ONE);
            put(LottoRank.SECOND, BigDecimal.ZERO);
            put(LottoRank.THIRD, BigDecimal.ZERO);
            put(LottoRank.FOURTH, BigDecimal.ZERO);
            put(LottoRank.FIFTH, BigDecimal.ZERO);
        }});
    }

    @Test
    @DisplayName("수익을 계산한다")
    void 성공_수익계산() {
        // Given
        LottoResult lottoResult = new LottoResult();
        lottoResult.add(LottoRank.FIRST);
        lottoResult.add(LottoRank.SECOND);

        // When
        BigDecimal profit = lottoResult.calculateProfit();

        // Then
        assertThat(profit).isEqualTo(LottoRank.FIRST.getAward().add(LottoRank.SECOND.getAward()));
    }
}
