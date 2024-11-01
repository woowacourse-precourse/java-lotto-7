package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import lotto.model.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankResultTest {

    @DisplayName("출력을 올바르게 한다")
    @Test
    void test_1() {
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> ranks.put(rank, 0));
        ranks.put(Rank.FIFTH, 1);

        assertThat(new RankResult(ranks).toString()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }
}
