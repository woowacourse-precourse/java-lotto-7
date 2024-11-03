package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
    @Test
    void 보너스_번호_숫자가_아니면_예외_발생() {
        String input = "10j";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 보너스_번호_1이상_45이하_아니면_예외_발생() {
        String input = "56";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 보너스_번호_1개_아니면_예외_발생() {
        String input = "1, 3";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SINGLE_NUMBER_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 보너스_번호_양수_아니면_예외_발생() {
        String input = "-10";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE.getMessage());
    }
}
