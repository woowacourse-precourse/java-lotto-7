package lotto.model.enums;

import static lotto.model.enums.Rank.*;
import static lotto.model.enums.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("로또_등수를_그룹화할_수_있다")
    @Test
    void 로또_등수를_그룹화할_수_있다() {
        //given
        List<Rank> ranks = List.of(FIRST, FIRST, FIRST, SECOND, SECOND, THIRD, FIFTH, NONE);

        //when
        Map<Rank, Long> rankLongMap = groupByRank(ranks);

        //then
        assertThat(rankLongMap.get(FIRST)).isEqualTo(3);
        assertThat(rankLongMap.get(SECOND)).isEqualTo(2);
        assertThat(rankLongMap.get(THIRD)).isEqualTo(1);
        assertThat(rankLongMap.get(FIFTH)).isEqualTo(1);
    }

    @DisplayName("로또의 등수를 알 수 있다")
    @Test
    void 로또의_등수를_알수_있다() {
        //given
        int match = 5;
        boolean bonus = false;

        //when
        Rank rank = checkRank(match, bonus);

        //then
        assertThat(rank).isEqualTo(THIRD);
    }
}