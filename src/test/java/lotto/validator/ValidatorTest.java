package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 숫자_형식이_아니면_예외가_발생한다() {
        assertThatThrownBy(()-> Validator.validateNumeric("하나"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(()-> Validator.validateAmountUnit(14500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_범위가_벗어나면_예외가_발생한다() {
        assertThatThrownBy(()-> Validator.validateLottoNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
