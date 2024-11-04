package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("일치하는 개수와 보너스 여부에 따라 적절한 등수를 반환한다")
    void 일치하는_개수와_보너스여부에_따라_등수를_반환한다() {
        // given & when & then
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("당첨금을 기준으로 내림차순 정렬된 등수 리스트를 반환한다")
    void 당첨금_기준으로_내림차순_정렬된_등수_리스트를_반환한다() {
        // when
        List<Rank> ranks = Rank.getDescendingRanks();

        // then
        assertThat(ranks).containsExactly(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
    }

    @Test
    @DisplayName("2등일 경우 보너스 번호 일치를 포함한 포맷된 결과를 반환한다")
    void 보너스_번호가_일치하는_경우_2등_포맷된_결과를_반환한다() {
        // given
        Rank secondPlace = Rank.SECOND;

        // when
        String formattedResult = secondPlace.getFormattedResult();

        // then
        assertThat(formattedResult).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
    }

    @Test
    @DisplayName("1등일 경우 포맷된 결과를 반환한다.")
    void 일치하는_개수가_6개인_경우_1등_포맷된_결과를_반환한다() {
        // given
        Rank firstPlace = Rank.FIRST;

        // when
        String formattedResult = firstPlace.getFormattedResult();

        // then
        assertThat(formattedResult).isEqualTo("6개 일치 (2,000,000,000원)");
    }

    @Test
    @DisplayName("3등일 경우 포맷된 결과를 반환한다")
    void 일치하는_개수가_5개인_경우_3등_포맷된_결과를_반환한다() {
        // given
        Rank thirdPlace = Rank.THIRD;

        // when
        String formattedResult = thirdPlace.getFormattedResult();

        // then
        assertThat(formattedResult).isEqualTo("5개 일치 (1,500,000원)");
    }

    @Test
    @DisplayName("당첨금이 없는 경우 빈 문자열을 반환한다")
    void 당첨금이_없는_경우_빈_문자열을_반환한다() {
        // given
        Rank miss = Rank.MISS;

        // when
        String formattedResult = miss.getFormattedResult();

        // then
        assertThat(formattedResult).isEqualTo("");
    }
}
