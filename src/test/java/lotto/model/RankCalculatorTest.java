package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankCalculatorTest {
    private RankCalculator rankCalculator;

    @BeforeEach
    void setUp() {
        this.rankCalculator = new RankCalculator();
    }

    @Test
    @DisplayName("일치하는 개수에 따라 올바른 등수를 나타내는지 확인하는 테스트")
    void confirmLottoRank(){
        assertThat(rankCalculator.determineRank(2,true)).isEqualTo("꽝");
        assertThat(rankCalculator.determineRank(3,true)).isEqualTo("5등");
        assertThat(rankCalculator.determineRank(4,true)).isEqualTo("4등");
        assertThat(rankCalculator.determineRank(5,false)).isEqualTo("3등");
        assertThat(rankCalculator.determineRank(5,true)).isEqualTo("2등");
        assertThat(rankCalculator.determineRank(6,true)).isEqualTo("1등");
    }

    @Test
    @DisplayName("등수 리스트를 받아서 당첨 개수를 제대로 나타내는지 확인하는 테스트")
    void checkRankingCount(){
        assertThat(rankCalculator.finalRank(List.of("5등","5등","5등","5등","꽝")))
                .containsEntry("5등",4)
                .containsEntry("꽝",1);
        assertThat(rankCalculator.finalRank(List.of("5등","4등","3등","5등","꽝")))
                .containsEntry("5등",2)
                .containsEntry("4등",1)
                .containsEntry("3등",1)
                .containsEntry("꽝",1);
    }
}