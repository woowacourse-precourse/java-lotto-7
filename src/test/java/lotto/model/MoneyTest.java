package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Exception.ExceptionMessage.*;

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
                .hasMessage(ZERO_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("1000원 단위의 구입금액이 아닌경우 예외발생")
    @Test
    void 구입금액이_1000원_단위가_아닌_경우_예외발생() {
        // given
        long invalidPurchaseAmount = 1001;

        // when
        Assertions.assertThatThrownBy(() -> money = new Money(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_THOUSAND_UNIT_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("수익률 계산")
    @Test
    void 수익률_정상계산() {
        // given
        money = new Money(8000);
        long totalPrize = 5000;
        String expectedReturnRate = "62.5%";

        // when
        String actualReturnRate = money.calculateReturnRate(totalPrize);

        // then
        Assertions.assertThat(actualReturnRate).isEqualTo(expectedReturnRate);
    }

}