package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountOfLottosTest {

    @Test
    @DisplayName("숫자가 아닌 값을 입력하는 경우 예외")
    public void notNumberException() {

        assertThatThrownBy(() -> new AmountOfLottos("temp", 1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 금액으로 나누어 떨어지지 않는 경우 예외")
    public void indivisibleException() {

        assertThatThrownBy(() -> new AmountOfLottos("1200", 1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
