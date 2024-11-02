package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.Validator;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 문자가_포함된_구입_금액을_입력_받으면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmountInput("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천_단위_이하의_숫자가_포함된_구입_금액을_입력_받으면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmountInput("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_양수가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmountInput("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_0인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmountInput("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
