package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @Test
    void 당첨_번호가_숫자가_아니면_예외가_발생한다() {
        String[] strings = new String[]{"string"};
        assertThatThrownBy(() -> Validation.validateWinningNumber(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_1부터_45까지가_아니면_예외가_발생한다() {
        String[] strings = new String[]{"1,2,3,4,5,46"};
        assertThatThrownBy(() -> Validation.validateWinningNumber(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.validateBonusNumber("string"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
