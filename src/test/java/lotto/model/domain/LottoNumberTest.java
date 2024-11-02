package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("각 숫자가 1 ~ 45 가 아닐 시 예외 반환한다")
    @Test
    void test1() {
        assertThatThrownBy(() -> new LottoNumber(47))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
