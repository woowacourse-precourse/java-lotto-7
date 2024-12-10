package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    void 일치하는_번호가_6개일_때_1등() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(6, false);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
        assertThat(rank.getPrize()).isEqualTo(2_000_000_000);
    }

    @Test
    void 일치하는_번호가_5개_보너스_일치하면_2등() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
        assertThat(rank.getPrize()).isEqualTo(30_000_000);
    }

    @Test
    void 일치하는_번호가_5개_보너스_불일치하면_3등() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
        assertThat(rank.getPrize()).isEqualTo(1_500_000);
    }

    @Test
    void 일치하는_번호가_4개_일때_4등() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(4, false);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
        assertThat(rank.getPrize()).isEqualTo(50_000);
    }

    @Test
    void 일치하는_번호가_3개_일때_5등() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(3, false);
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
        assertThat(rank.getPrize()).isEqualTo(5_000);
    }

    @Test
    void 일치하는_번호가_2개_이하_일때_꽝() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(2, false);
        assertThat(rank).isEqualTo(LottoRank.MISS);
        assertThat(rank.getPrize()).isEqualTo(0);
    }
}
