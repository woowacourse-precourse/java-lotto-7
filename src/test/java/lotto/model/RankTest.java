package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("당첨 결과를 표기한다.")
    @Test
    void test() {
        //given
        WinningResult result = new WinningResult(Map.of(
            Rank.FIRST, 1,
            Rank.SECOND, 2,
            Rank.THIRD, 3,
            Rank.FOURTH, 4,
            Rank.FIFTH, 5,
            Rank.NONE, 0)
        );
        //when
        String notation = Rank.notationFrom(result);
        //then
        assertThat(notation)
            .isEqualTo(
                "6개 일치 (2,000,000,000원) - 1개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                    "5개 일치 (1,500,000원) - 3개\n" +
                    "4개 일치 (50,000원) - 4개\n" +
                    "3개 일치 (5,000원) - 5개\n"
            );
    }
}