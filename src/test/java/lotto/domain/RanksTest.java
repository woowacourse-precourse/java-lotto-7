package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @DisplayName("등수 목록으로 생성할 수 있다.")
    @Test
    void createRanksWithRankList() {
        List<Rank> rankList = List.of(FIRST, SECOND, THIRD, FOURTH);

        Ranks ranks = new Ranks(rankList);

        assertThat(ranks.count()).isEqualTo(4);
    }

}
