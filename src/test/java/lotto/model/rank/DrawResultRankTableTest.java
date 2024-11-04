package lotto.model.rank;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.helper.DrawResultRankTableHelper;
import lotto.helper.MoneyHelper;
import lotto.model.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DrawResultRankTableTest {

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
