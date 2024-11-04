package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static lotto.constant.ErrorMessage.PURCHASE_PRICE_ERROR;
import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("로또 금액과 나머지 연산한 결과가 0이 아니면 예외가 발생한다.")
    void 로또_금액과_나머지_연산한_결과가_0이_아니면_예외가_발생한다() {
        //given
        Integer amount = 12500;

        //when //then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_PRICE_ERROR.getMessage());
    }

    @Test
    @DisplayName("구매한 금액만큼 금액을 차감한다")
    void 구매한_금액만큼_금액을_차감한다() {
        //given
        Money myMoney = new Money(10000);
        Money minusMoney = new Money(8000);

        //when
        myMoney.minus(minusMoney);

        //then
        assertThat(myMoney.getAmount()).isEqualTo(2000L);
    }
}