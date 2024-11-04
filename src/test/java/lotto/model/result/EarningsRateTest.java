package lotto.model.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.fixture.MoneyFixture;
import lotto.model.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EarningsRateTest {

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률을_계산한다() {
        Money totalPrize = MoneyFixture.create(5000);
        Money purchaseAmount = MoneyFixture.create(8000);
        EarningsRate rate = EarningsRate.from(totalPrize, purchaseAmount);
        assertThat(rate.toString()).isEqualTo("62.5%");
    }
}
