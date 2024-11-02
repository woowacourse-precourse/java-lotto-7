package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 숫자가 아니라면 예외가 발생한다.")
    void validateType() {
        assertThatThrownBy(() -> LottoNumber.of("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
