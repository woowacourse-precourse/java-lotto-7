package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoRankTest {
    @DisplayName("당첨 금액이 정확히 설정되어 있다")
    @Test
    void validatePrizeAmount() {
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(LottoRank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(5_000);
        assertThat(LottoRank.NONE.getPrize()).isEqualTo(0);
    }

    @DisplayName("맞춘 개수와 보너스 번호 일치 여부로 정확한 등수를 반환한다")
    @Test
    void validateRankCalculation() {
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.NONE);
    }
}