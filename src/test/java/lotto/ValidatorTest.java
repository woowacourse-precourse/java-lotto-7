package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 구입_금액이_음수일_경우_예외() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_6개가_아니면_예외() {
        assertThatThrownBy(() -> validator.validateWinningNum(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_범위를_벗어나면_예외() {
        assertThatThrownBy(() -> validator.validateWinningNum(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
