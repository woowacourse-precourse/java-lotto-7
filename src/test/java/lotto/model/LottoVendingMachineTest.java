package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoVendingMachineTest {

    @DisplayName("구입 금액은 일정 가격 이하일 수 없다.")
    @Test
    void costShouldOverMinPrice() {
        assertThatThrownBy(() -> new LottoVendingMachine(999))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구매 금액이 부족합니다. 최소 1000원 이상 입력해주세요.");
    }

    @DisplayName("로또 구매금액은 나누어 떨어지는 금액이어야 한다.")
    @Test
    void costShouldDivideByPrice() {
        assertThatThrownBy(() -> new LottoVendingMachine(1500))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
    }

    @DisplayName("로또를 구매한다.")
    @Test
    void purchaseAll() {
        //given
        LottoVendingMachine vendingMachine = new LottoVendingMachine(3000);
        //when
        List<Lotto> lottos = vendingMachine.purchaseAll(() -> List.of(1, 2, 3, 4, 5, 6));
        //then
        assertThat(lottos).hasSize(3)
            .extracting("numbers")
            .containsExactlyInAnyOrder(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6)
            );
    }

}