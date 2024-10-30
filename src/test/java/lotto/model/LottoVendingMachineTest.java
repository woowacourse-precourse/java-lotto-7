package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoVendingMachineTest {

    @DisplayName("구입 금액은 일정 가격 이하일 수 없다.")
    @Test
    void costShouldOverMinPrice() {
        assertThatThrownBy(() -> new LottoVendingMachine(999))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
    }

    @DisplayName("로또 구매금액은 나누어 떨어지는 금액이어야 한다.")
    @Test
    void costShouldDivideByPrice() {
        assertThatThrownBy(() -> new LottoVendingMachine(1500))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
    }

    @DisplayName("구매 가능한 로또의 개수를 확인 할 수 있다.")
    @Test
    void getAvailableQuantity() {
        //given
        LottoVendingMachine vendingMachine = new LottoVendingMachine(3000);
        //when
        int quantity = vendingMachine.getAvailableQuantity();
        //then
        assertThat(quantity).isEqualTo(3);
    }

}