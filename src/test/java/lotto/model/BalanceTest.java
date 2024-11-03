package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BalanceTest {
    @DisplayName("구입금액이 1000보다 작으면 예외가 발생한다.")
    @Test
    void balanceUnderZero() {
        assertThatThrownBy(() -> new Balance(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void balanceNotMultipleOfThousand() {
        assertThatThrownBy(() -> new Balance(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
