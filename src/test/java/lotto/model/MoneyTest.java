package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    private Money money;

    @Test
    @DisplayName("천원_단위_금액이_입력된_경우_로또개수_정상으로_계산")
    void 천원_단위_금액이_입력된_경우_로또개수_정상으로_계산() {
        // given
        long validPurchaseAmount = 5000;
        long expectedUnitCount = 5;

        // when
        money = new Money(validPurchaseAmount);
        long actualUnitCount = money.getThousandUnitCount();

        // then
        Assertions.assertThat(actualUnitCount).isEqualTo(expectedUnitCount);
    }

}