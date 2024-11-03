package lotto;
import lotto.common.error.MoneyErrorMessage;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyUnitTest {
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다(){
        // given
        int invalidAmount = 5500;

        // when & then
        assertThatThrownBy(() -> new Money(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MoneyErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getInfoMessage());
    }

    @DisplayName("구입 금액이 0원 미만이면 예외가 발생한다.")
    @Test
    void 구입_금액이_0원_미만이면_예외가_발생한다() {
        // given
        int invalidAmount = -1000;

        // when & then
        assertThatThrownBy(() -> new Money(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MoneyErrorMessage.INVALID_PURCHASE_AMOUNT_VALUE.getInfoMessage());
    }

    @DisplayName("유효한 금액이 입력되면 Money 객체가 생성된다.")
    @Test
    void 유효한_금액으로_객체_생성가_생성된다() {
        // given
        int validAmount = 5000;

        // when
        Money money = new Money(validAmount);

        // then
        assertThat(money.getAmount()).isEqualTo(validAmount);
    }
}
