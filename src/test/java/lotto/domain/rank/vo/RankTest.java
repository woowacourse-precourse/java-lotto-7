package lotto.domain.rank.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    @DisplayName("각 등수마다 올바른 조건을 출력할 수 있다.")
    void 출력_테스트() {
        assertThat(Rank.FIRST.toString()).contains("6개", "2,000,000,000");
        assertThat(Rank.SECOND.toString()).contains("5개", "보너스", "30,000,000");
        assertThat(Rank.THIRD.toString()).contains("5개", "1,500,000");
        assertThat(Rank.FOURTH.toString()).contains("4개", "50,000");
        assertThat(Rank.FIFTH.toString()).contains("3개", "5,000");
    }

    @ParameterizedTest
    @DisplayName("매칭 개수와 보너스 개수를 통해 올바른 등수 정보를 반환할 수 있다.")
    @CsvSource({"6, 0, FIRST", "5, 1, SECOND", "5, 0, THIRD", "4, 0, FOURTH", "3, 0, FIFTH"})
    void 생성_테스트(int match, int bonus, String rank) {
        // given
        // when
        Rank rankInfo = Rank.of(match, bonus);

        // then
        assertThat(rankInfo).isEqualByComparingTo(Rank.valueOf(rank));
    }

    @Test
    @DisplayName("낮은 순위부터 높은 순위까지 전체 순위를 순서대로 반환할 수 있다.")
    void 순위_객체_반환() {
        // given
        // when
        List<Rank> sortedRanks = Rank.getSortedRanks();

        // then
        assertThat(sortedRanks).containsExactly(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
    }
}