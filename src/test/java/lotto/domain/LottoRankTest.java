package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    @DisplayName("세 개의 번호가 일치하는 경우 올바른 등수 반환")
    void 세_개의_번호가_일치하는_경우_올바른_등수_반환() {
        // given
        LottoResult result = new LottoResult(3, false);

        // when
        LottoRank rank = LottoRank.findByMatchAndBonus(result.getMatchCount(), result.isBonusMatched());

        // then
        assertEquals(LottoRank.THREE_MATCHES, rank);
    }

    @Test
    @DisplayName("네 개의 번호가 일치하는 경우 올바른 등수 반환")
    void 네_개의_번호가_일치하는_경우_올바른_등수_반환() {
        // given
        LottoResult result = new LottoResult(4, false);

        // when
        LottoRank rank = LottoRank.findByMatchAndBonus(result.getMatchCount(), result.isBonusMatched());

        // then
        assertEquals(LottoRank.FOUR_MATCHES, rank);
    }

    @Test
    @DisplayName("다섯 개의 번호가 일치하지만 보너스 번호가 일치하지 않는 경우 올바른 등수 반환")
    void 다섯_개의_번호가_일치하지만_보너스_번호가_일치하지_않는_경우_올바른_등수_반환() {
        // given
        LottoResult result = new LottoResult(5, false);

        // when
        LottoRank rank = LottoRank.findByMatchAndBonus(result.getMatchCount(), result.isBonusMatched());

        // then
        assertEquals(LottoRank.FIVE_MATCHES, rank);
    }

    @Test
    @DisplayName("다섯 개의 번호가 일치하고 보너스 번호도 일치하는 경우 올바른 등수 반환")
    void 다섯_개의_번호가_일치하고_보너스_번호도_일치하는_경우_올바른_등수_반환() {
        // given
        LottoResult result = new LottoResult(5, true);

        // when
        LottoRank rank = LottoRank.findByMatchAndBonus(result.getMatchCount(), result.isBonusMatched());

        // then
        assertEquals(rank, LottoRank.FIVE_MATCHES_WITH_BONUS);
    }

    @Test
    @DisplayName("여섯 개의 번호가 일치하는 경우 올바른 등수 반환")
    void 여섯_개의_번호가_일치하는_경우_올바른_등수_반환() {
        // given
        LottoResult result = new LottoResult(6, false);

        // when
        LottoRank rank = LottoRank.findByMatchAndBonus(result.getMatchCount(), result.isBonusMatched());

        // then
        assertEquals(rank, LottoRank.SIX_MATCHES);
    }

    @Test
    @DisplayName("매칭된 번호가 없는 경우 NON_MATCHES 반환")
    void 매칭된_번호가_없는_경우_NON_MATCHES_반환() {
        // given
        LottoResult result = new LottoResult(0, false);

        // when
        LottoRank rank = LottoRank.findByMatchAndBonus(result.getMatchCount(), result.isBonusMatched());

        // then
        assertEquals(rank, LottoRank.NON_MATCHES);
    }

}