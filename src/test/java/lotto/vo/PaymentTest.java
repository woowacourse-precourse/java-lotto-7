package lotto.vo;

import lotto.model.MainNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {
    @Test
    void 음수_예외_처리() {
        assertThatThrownBy(() -> new Payment("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천단위_아닐_경우_예외_처리() {
        assertThatThrownBy(() -> new Payment("10"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
