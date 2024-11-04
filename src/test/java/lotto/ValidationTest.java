package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void 보너스_번호가_1부터_45까지가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.validateBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Validation.ValidateWinningNumberContainsBonusNumber(winningNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
