package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 숫자가 아니라면 예외가 발생한다.")
    void validateType() {
        assertThatThrownBy(() -> LottoNumber.from("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1에서 45사이의 숫자가 아니라면 예외가 발생한다.")
    void validateRange() {
        assertThatThrownBy(() -> LottoNumber.from("46"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumber.from("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
