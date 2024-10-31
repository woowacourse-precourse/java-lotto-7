package lotto.model.rank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.helper.DrawResultRankTableHelper;
import lotto.helper.MoneyHelper;
import lotto.model.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DrawResultRankTableTest {

    @Test
    @DisplayName("결과 테이블 초기화")
    void initResultRankTable() {
        // given
        DrawResultRankTable mock = DrawResultRankTableHelper.initiate();

        // when
        int rankValue1 = mock.getRankValue(RankCondition.FIRST);
        int rankValue2 = mock.getRankValue(RankCondition.SECOND);
        int rankValue3 = mock.getRankValue(RankCondition.THIRD);
        int rankValue4 = mock.getRankValue(RankCondition.FOURTH);
        int rankValue5 = mock.getRankValue(RankCondition.FIRST);

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
        DrawResultRankTable mock = DrawResultRankTableHelper.initiate();

        // when
        mock.updateResultRankTable(RankCondition.FIRST);
        int actual = mock.getRankValue(RankCondition.FIRST);

        // then
        int expected = 1;
        assertThat(actual == expected).isTrue();
    }

    @Test
    @DisplayName("[2등 한 개, 3등 두 개] 총 받을 수 있는 상금 계산")
    void calculateTotalPrizeAmount() {
        // given
        DrawResultRankTable mock = DrawResultRankTableHelper.oneSecondRankAndTwoThirdRank();

        // when
        Money actual = mock.totalPrizeAmount();

        // then
        Money expected = MoneyHelper.mock(33000000L);
        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    @DisplayName("[5등 한 개] 총 받을 수 있는 상금 계산")
    void calculateTotalPrizeAmountCase2() {
        // given
        DrawResultRankTable mock = DrawResultRankTableHelper.oneFifthRank();

        // when
        Money actual = mock.totalPrizeAmount();

        // then
        Money expected = MoneyHelper.mock(5000L);
        assertThat(actual.equals(expected)).isTrue();
    }
}
