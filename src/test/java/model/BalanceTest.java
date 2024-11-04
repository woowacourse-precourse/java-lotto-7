package model;

import lotto.model.Balance;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static lotto.constant.Constants.LOTTO_PRICE;

public class BalanceTest {

    @Test
    void createBalance_WithValidAmount_ShouldCreateSuccessfully() {
        // given
        int money = 5000;

        // when
        Balance balance = new Balance(money);

        // then
        assertThat(balance.getMoney()).isEqualTo(money);
        assertThat(balance.getTicket()).isEqualTo(money / LOTTO_PRICE);
    }

    @Test
    void createBalance_WithAmountLessThan1000_ShouldThrowException() {
        // given
        int money = 500;

        // when & then
        assertThatThrownBy(() -> new Balance(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1,000원 이상이어야 합니다.");
    }

    @Test
    void createBalance_WithNonMultipleOf1000_ShouldThrowException() {
        // given
        int money = 1500;

        // when & then
        assertThatThrownBy(() -> new Balance(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
    }
}
