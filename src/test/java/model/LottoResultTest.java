package model;

import lotto.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void 매칭_개수와_상금_확인() {
        assertThat(LottoResult.THREE_NUMBER_MATCH.lottoMatchCount()).isEqualTo(3);
        assertThat(LottoResult.THREE_NUMBER_MATCH.lottoPrize()).isEqualTo(5000);

        assertThat(LottoResult.FOUR_NUMBER_MATCH.lottoMatchCount()).isEqualTo(4);
        assertThat(LottoResult.FOUR_NUMBER_MATCH.lottoPrize()).isEqualTo(50000);

        assertThat(LottoResult.FIVE_NUMBER_MATCH.lottoMatchCount()).isEqualTo(5);
        assertThat(LottoResult.FIVE_NUMBER_MATCH.lottoPrize()).isEqualTo(1500000);

        assertThat(LottoResult.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH.lottoMatchCount()).isEqualTo(5);
        assertThat(LottoResult.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH.lottoPrize()).isEqualTo(30000000);

        assertThat(LottoResult.SIX_NUMBER_MATCH.lottoMatchCount()).isEqualTo(6);
        assertThat(LottoResult.SIX_NUMBER_MATCH.lottoPrize()).isEqualTo(2000000000);
    }

    @Test
    void 보너스_매치_확인() {
        assertThat(LottoResult.isBonusMatch(5, true)).isTrue();
        assertThat(LottoResult.isBonusMatch(5, false)).isFalse();
        assertThat(LottoResult.isBonusMatch(4, true)).isFalse();
    }
}
