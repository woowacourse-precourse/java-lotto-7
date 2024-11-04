package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("구입금액이 1,000원 단위가 아니면 예외가 발생한다")
    @Test
    void occur() {
        assertThatThrownBy(() -> Money.createMoney(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
