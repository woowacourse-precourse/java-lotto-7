package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("유효한 금액 성공 검증")
    void 유효한_금액_성공_검증() {
        //given
        int validMoney = 1000;

        //when
        Money money = new Money(validMoney);

        //then
        assertThat(money.getMoney()).isEqualTo(validMoney);
    }

    @Test
    @DisplayName("금액이 0원일 경우 예외 검증")
    void 금액_0원_예외_검증() {
        //given
        int invalidMoneyZero = 0;

        //when
        try {
            Money invalidMoney = new Money(invalidMoneyZero);
        } catch (LottoException e) {
            assertThat("[ERROR] 구입 금액은 0원이 아닌 수를 입력하셔야 합니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> new Money(invalidMoneyZero))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.LOTTO_PURCHASE_IS_ZERO.getErrorMessage());
    }

    @Test
    @DisplayName("금액이 천원 단위가 아닐 경우 예외 검증")
    void 금액_천원_단위_검증() {
        //given
        int invalidUnitMoney = 1100;

        //when
        try {
            Money invalidMoney = new Money(invalidUnitMoney);
        } catch (LottoException e) {
            assertThat("[ERROR] 구입 금액은 1,000원 단위로 입력하셔야 합니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> new Money(invalidUnitMoney))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.LOTTO_PURCHASE_IS_NOT_THOUSAND_UNIT.getErrorMessage());
    }
}
