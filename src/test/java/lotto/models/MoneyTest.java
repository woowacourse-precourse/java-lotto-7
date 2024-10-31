package lotto.models;

import static org.assertj.core.api.Assertions.*;

import lotto.dto.PurchaseMoneyRequestDTO;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("정확한 Money 객체를 생성한다.")
    public void correctMoney() {
        // GIVEN
        String input = "10000";
        PurchaseMoneyRequestDTO request = new PurchaseMoneyRequestDTO(input);

        // WHEN
        Money money = new Money(request);

        // THEN
        assertThat(money.getMoney()).isEqualTo(10000);
    }

    @Test
    @DisplayName("금액 단위에 맞지 않는 경우, 예외를 발생시킨다.")
    public void moneyUnit() {
        // GIVEN
        String input = "10100";
        PurchaseMoneyRequestDTO request = new PurchaseMoneyRequestDTO(input);

        // WHEN - THEN
        assertThatThrownBy(() -> new Money(request)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액 범위를 초과하는 경우, 예외를 발생시킨다.")
    public void range() {
        // GIVEN
        PurchaseMoneyRequestDTO over = new PurchaseMoneyRequestDTO("101000");
        PurchaseMoneyRequestDTO under = new PurchaseMoneyRequestDTO("0");

        // WHEN - THEN
        assertThatThrownBy(() -> new Money(over)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Money(under)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매 시, 정확한 개수의 로또와 교환된다.")
    public void exchange() {
        // GIVEN
        Money money = new Money(new PurchaseMoneyRequestDTO("10000"));

        // WHEN
        int count = money.exchangedForLottos();

        // THEN
        assertThat(count).isEqualTo(10);
        assertThat(money.getMoney()).isEqualTo(0);
    }
}
