package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {
    @Test
    @DisplayName("로또 구입금액의 단위가 1000이 아니라면 예외가 발생한다")
    void validateUnit() {
        assertThatThrownBy(() -> Amount.from("2500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입금액의 타입이 숫자가 아니라면 예외가 발생한다")
    void validateType() {
        assertThatThrownBy(() -> Amount.from("2000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
