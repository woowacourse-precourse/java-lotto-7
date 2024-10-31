package lotto.model.rank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.helper.ResultRankTableHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DrawResultRankTableTest {

    @Test
    @DisplayName("결과 테이블 초기화")
    void initResultRankTable() {
        // given
        DrawResultRankTable mock = ResultRankTableHelper.mock();

        // when
        int rankValue1 = mock.getRankValue(Rank.FIRST);
        int rankValue2 = mock.getRankValue(Rank.SECOND);
        int rankValue3 = mock.getRankValue(Rank.THIRD);
        int rankValue4 = mock.getRankValue(Rank.FOURTH);
        int rankValue5 = mock.getRankValue(Rank.FIRST);

        // then
        int expected = 0;
        assertAll(
                () -> assertThat(rankValue1 == expected).isTrue(),
                () -> assertThat(rankValue2 == expected).isTrue(),
                () -> assertThat(rankValue3 == expected).isTrue(),
                () -> assertThat(rankValue4 == expected).isTrue(),
                () -> assertThat(rankValue5 == expected).isTrue()
        );
    }

    @Test
    @DisplayName("결과 테이블 수정/조회")
    void updateAndGetTest() {
        // given
        DrawResultRankTable mock = ResultRankTableHelper.mock();

        // when
        mock.updateResultRankTable(Rank.FIRST);
        int actual = mock.getRankValue(Rank.FIRST);

        // then
        int expected = 1;
        assertThat(actual == expected).isTrue();
    }
}
