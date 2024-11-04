package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.model.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountTest {
    @Test
    @DisplayName("금액이 문자면 예외가 발생한다.")
    void createAmountByType() {
        assertThatThrownBy(() -> new Amount("ㅏ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원보다 작으면 예외가 발생한다.")
    void createAmountByMin() {
        assertThatThrownBy(() -> new Amount("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void createAmountByDivision() {
        assertThatThrownBy(() -> new Amount("5678"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
