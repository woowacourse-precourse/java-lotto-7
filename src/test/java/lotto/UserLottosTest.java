package lotto;

import lotto.model.UserLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserLottosTest {
    @DisplayName("구입금액이 나누어떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void throwWhenPurchaseAmountIsNotDivisible() {
        assertThatThrownBy(() -> new UserLottos(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
