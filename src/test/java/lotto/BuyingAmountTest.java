package lotto;

import lotto.validator.BuyingAmountValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyingAmountTest {
    private final BuyingAmountValidator validator = new BuyingAmountValidator();

    @Test
    void 정상적인_입력() {
        assertThat(validator.validateBuyingAmount("18000")).isEqualTo(18000);
    }

    @Test
    void 입력의_길이가_6보다_길면_예외_발생() {
        assertThatThrownBy(() -> validator.validateBuyingAmount("1800000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_숫자_형태가_아니면_예외_발생() {
        assertThatThrownBy(() -> validator.validateBuyingAmount("만팔천원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_1000원_단위가_아니면_예외_발생() {
        assertThatThrownBy(() -> validator.validateBuyingAmount("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_1000원보다_작거나_10만원보다_크면_예외_발생() {
        assertThatThrownBy(() -> validator.validateBuyingAmount("-5000"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
