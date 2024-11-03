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

    @DisplayName("0원이 입력된 경우 예외발생")
    @Test
    void 구입금액이_0원인_경우_예외발생() {
        // given
        long zero = 0;

        // when
        Assertions.assertThatThrownBy(() -> money = new Money(zero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또를 구매할 수 없습니다.");
    }

}