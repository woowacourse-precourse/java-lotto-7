package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @DisplayName("로또 가격보다 적은 금액을 입력하면 예외가 발생한다.")
    @Test
    void 로또_가격_보다_적은_금액은_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(500L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 1장가격보다 큰 수이어야 합니다");
    }

    @DisplayName("로또 티켓 단위가 아닌 금액을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {1500L, 2501L, 1050L})
    void 로또_티켓_단위가_아닌_금액은_예외가_발생한다(Long invalidAmount) {
        assertThatThrownBy(() -> new Money(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 가격 배수로 입력해주세요, 로또 1장은 1000원입니다.");
    }

    @DisplayName("유효한 금액이 입력되면 Money 객체가 생성된다.")
    @Test
    void 유효한_금액으로_Money_객체가_생성된다() {
        Money money = new Money(4000L);
        assertThat(money.getMoney()).isEqualTo(4000L);
    }

    @DisplayName("유효한 금액으로 구매 가능한 로또 티켓 수를 반환한다.")
    @Test
    void 구매_가능한_로또_티켓_수를_반환한다() {
        Money money = new Money(5000L);
        assertThat(money.getTickets()).isEqualTo(5);
    }
}
