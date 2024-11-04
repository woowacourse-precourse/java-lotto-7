package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import lotto.exception.MoneyException;
import lotto.exception.MoneyExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("금액이 1,000원 단위가 아닐 때 예외가 발생한다")
    void 금액이_천원_단위가_아닐_때_예외_발생_테스트() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(MoneyException.class)
                .hasMessage(MoneyExceptionType.NOT_UNIT_MONEY.errorMessage());
    }

    @Test
    @DisplayName("getTicket 메서드는 1,000원당 1개의 티켓 수를 반환한다")
    void getTicket_티켓_수_테스트() {
        Money money = new Money(7000);
        assertThat(money.getTicket()).isEqualTo(7);
    }

}