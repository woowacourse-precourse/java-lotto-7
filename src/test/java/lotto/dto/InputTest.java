package lotto.dto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    @DisplayName("정확한 구입 금액을 받는다.")
    public void purchaseMoney() {
        // GIVEN
        String input = "10000";

        // WHEN
        PurchaseMoneyRequestDTO purchaseMoneyRequestDTO = new PurchaseMoneyRequestDTO(input);

        // THEN
        assertThat(purchaseMoneyRequestDTO.getMoney()).isEqualTo(10000);
    }

    @Test
    @DisplayName("구입금액이 숫자가 아닌 경우 예외를 발생시킨다.")
    public void notNumberMoney() {
        // GIVEN
        String input = "12abc";

        // WHEN - THEN
        assertThatThrownBy(() -> new PurchaseMoneyRequestDTO(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
