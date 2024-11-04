package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    void 당첨번호_6개_일치_시_1등() {
        LottoRank rank = LottoRank.getRank(6, false);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 당첨번호_5개_일치_보너스번호_일치시_2등() {
        LottoRank rank = LottoRank.getRank(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 당첨번호_5개_일치_시_3등() {
        LottoRank rank = LottoRank.getRank(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 당첨번호_4개_일치_시_4등() {
        LottoRank rank = LottoRank.getRank(4, false);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 당첨번호_3개_일치_시_5등() {
        LottoRank rank = LottoRank.getRank(3, false);
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 당첨번호_3개_미만_미당첨() {
        LottoRank rank = LottoRank.getRank(0, false);
        assertThat(rank).isEqualTo(LottoRank.MISS);
    }
}