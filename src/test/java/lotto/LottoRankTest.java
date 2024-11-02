package lotto;

import lotto.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoRankTest {
    @DisplayName("6개 일치 시 1등 랭크를 반환한다")
    @Test
    void calculateRank_6_matches() {
        LottoRank rank1 = LottoRank.calculateRank(6, true);
        assertThat(rank1).isEqualTo(LottoRank.FIRST);
        LottoRank rank2 = LottoRank.calculateRank(6, false);
        assertThat(rank2).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("5개 일치하고 보너스 번호 일치 시 2등 랭크를 반환한다")
    @Test
    void calculateRank_5_matches_bonus_correct() {
        LottoRank rank = LottoRank.calculateRank(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("5개 일치하고 보너스 번호 불일치 시 3등 랭크를 반환한다")
    @Test
    void calculateRank_5_matches_bonus_incorrect() {
        LottoRank rank = LottoRank.calculateRank(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4개 일치 시 4등 랭크를 반환한다")
    @Test
    void calculateRank_4_matches() {
        LottoRank rank1 = LottoRank.calculateRank(4, true);
        assertThat(rank1).isEqualTo(LottoRank.FOURTH);
        LottoRank rank2 = LottoRank.calculateRank(4, false);
        assertThat(rank2).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("3개 일치 시 5등 랭크를 반환한다")
    @Test
    void calculateRank_3_matches() {
        LottoRank rank1 = LottoRank.calculateRank(3, true);
        assertThat(rank1).isEqualTo(LottoRank.FIFTH);
        LottoRank rank2 = LottoRank.calculateRank(3, false);
        assertThat(rank2).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("2개 이하 일치 시 낙첨 랭크를 반환한다")
    @Test
    void calculateRank_2_under_matches() {
        LottoRank rank1 = LottoRank.calculateRank(2, true);
        assertThat(rank1).isEqualTo(LottoRank.NONE);
        LottoRank rank2 = LottoRank.calculateRank(1, true);
        assertThat(rank2).isEqualTo(LottoRank.NONE);
        LottoRank rank3 = LottoRank.calculateRank(0, true);
        assertThat(rank3).isEqualTo(LottoRank.NONE);
        LottoRank rank4 = LottoRank.calculateRank(2, false);
        assertThat(rank4).isEqualTo(LottoRank.NONE);
        LottoRank rank5 = LottoRank.calculateRank(1, false);
        assertThat(rank5).isEqualTo(LottoRank.NONE);
        LottoRank rank6 = LottoRank.calculateRank(0, false);
        assertThat(rank6).isEqualTo(LottoRank.NONE);
    }

    @DisplayName("각 랭크의 상금과 매치 개수 확인")
    @Test
    void rankProperties_areCorrect() {
        assertThat(LottoRank.FIRST.getMatchCount()).isEqualTo(6);
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2000000000);
        assertThat(LottoRank.FIRST.getRankName()).isEqualTo("1등");
        assertThat(LottoRank.FIRST.isBonusRequired()).isFalse();

        assertThat(LottoRank.SECOND.getMatchCount()).isEqualTo(5);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30000000);
        assertThat(LottoRank.SECOND.getRankName()).isEqualTo("2등");
        assertThat(LottoRank.SECOND.isBonusRequired()).isTrue();
    }

    @DisplayName("낙첨 랭크는 getAllRanks 목록에 포함되지 않는다")
    @Test
    void noneRank_isNotIncludedInGetAllRanks() {
        assertThat(LottoRank.getAllRanks()).doesNotContain(LottoRank.NONE);
    }
}
