package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
    @Test
    void 보너스_번호_숫자가_아니면_예외_발생() {
        String input = "10j";
        List<Integer> winningNumbers = new ArrayList<>();

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 보너스_번호_1이상_45이하_아니면_예외_발생() {
        String input = "56";
        List<Integer> winningNumbers = new ArrayList<>();

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 보너스_번호_1개_아니면_예외_발생() {
        String input = "1, 3";
        List<Integer> winningNumbers = new ArrayList<>();

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SINGLE_NUMBER_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 보너스_번호_양수_아니면_예외_발생() {
        String input = "-10";
        List<Integer> winningNumbers = new ArrayList<>();

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 보너스_번호_당첨_번호_중복되면_예외_발생() {
        String input = "10";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 10);

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
    }
}
