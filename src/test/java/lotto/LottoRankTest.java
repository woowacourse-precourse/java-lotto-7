package lotto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void 일등_당첨_테스트() {
        LottoRank rank = LottoRank.valueOf(6, false);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 이등_당첨_테스트() {
        LottoRank rank = LottoRank.valueOf(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 삼등_당첨_테스트() {
        LottoRank rank = LottoRank.valueOf(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 사등_당첨_테스트() {
        LottoRank rank = LottoRank.valueOf(4, false);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 오등_당첨_테스트() {
        LottoRank rank = LottoRank.valueOf(3, false);
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }
}