package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    void 당첨_번호가_3개_일치할_때_5등과_상금_확인() {
        Rank rank = Rank.FIFTH;
        assertThat(rank.getRankWinning()).isEqualTo(3);
        assertThat(rank.getRankMoney()).isEqualTo(5_000);
        assertThat(rank.getRankBonus()).isFalse();
    }

    @Test
    void 당첨_번호가_4개_일치할_때_4등과_상금_확인() {
        Rank rank = Rank.FOURTH;
        assertThat(rank.getRankWinning()).isEqualTo(4);
        assertThat(rank.getRankMoney()).isEqualTo(50_000);
        assertThat(rank.getRankBonus()).isFalse();
    }

    @Test
    void 당첨_번호가_5개_일치할_때_3등과_상금_확인() {
        Rank rank = Rank.THIRD;
        assertThat(rank.getRankWinning()).isEqualTo(5);
        assertThat(rank.getRankMoney()).isEqualTo(1_500_000);
        assertThat(rank.getRankBonus()).isFalse();
    }

    @Test
    void 당첨_번호가_5개_일치하고_보너스_번호_일치할_때_2등과_상금_확인() {
        Rank rank = Rank.SECOND;
        assertThat(rank.getRankWinning()).isEqualTo(5);
        assertThat(rank.getRankMoney()).isEqualTo(30_000_000);
        assertThat(rank.getRankBonus()).isTrue();
    }

    @Test
    void 당첨_번호가_6개_일치할_때_1등과_상금_확인() {
        Rank rank = Rank.FIRST;
        assertThat(rank.getRankWinning()).isEqualTo(6);
        assertThat(rank.getRankMoney()).isEqualTo(2_000_000_000);
        assertThat(rank.getRankBonus()).isFalse();
    }

}
