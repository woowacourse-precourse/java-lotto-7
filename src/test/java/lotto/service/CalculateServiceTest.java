package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.helper.DrawResultRankTableHelper;
import lotto.helper.MoneyHelper;
import lotto.model.money.Money;
import lotto.model.rank.DrawResultRankTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateServiceTest {

    private final CalculateService sut = new CalculateService();

    @Test
    @DisplayName("[2등 한 개, 3등 두 개] 총 받을 수 있는 상금 계산")
    void calculateTotalPrizePrice() {
        // given
        DrawResultRankTable mock = DrawResultRankTableHelper.oneSecondRankAndTwoThirdRank();

        // when
        Money actual = sut.totalPriceFrom(mock);

        // then
        Money expected = MoneyHelper.mock(33000000L);
        assertThat(actual.equals(expected)).isTrue();
    }
}
