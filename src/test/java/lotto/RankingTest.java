package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingTest {
    @Test
    @DisplayName("등수 증가 함수 테스트")
    void incrementCountTest() {
        Ranking.FIFTH.incrementCount();

        assertThat(Ranking.FIFTH.getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("등수 찾기 함수 테스트")
    void findByMatchCountAndBonusTest() {
        assertThat(Ranking.findByMatchCountAndBonus(3, false)).isEqualTo(Ranking.FIFTH);
    }

    @Test
    @DisplayName("총 상금 계산 함수 테스트")
    void calculateTotalPrizeMoneyTest() {
        Ranking.SECOND.incrementCount();
        Ranking.THIRD.incrementCount();
        Ranking.FOURTH.incrementCount();
        Ranking.FIFTH.incrementCount();

        assertThat(Ranking.calculateTotalPrizeMoney()).isEqualTo(31555000);
    }
}
