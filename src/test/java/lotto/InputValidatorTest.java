package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.service.InputValidator;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    void 구매금액이_음수이면_예외가_발생합니다() {
        assertThatThrownBy(() -> validator.validateTotalPurchaseAmount("-5000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값은 양수여야 합니다.");
    }

    @Test
    void 구매금액이_숫자가_아니면_예외가_발생합니다() {
        assertThatThrownBy(() -> validator.validateTotalPurchaseAmount("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값은 양수여야 합니다.");
    }

    @Test
    void 보너스번호가_양의정수가_아니면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validateBonusNumber("a", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값은 양수여야 합니다.");
    }

    @Test
    void 보너스번호가_1에서_45_사이가_아니면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validateBonusNumber("46", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validateBonusNumber("3", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자여야 합니다.");
    }

    @Test
    void 당첨번호가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("a, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자와 쉼표만 포함해야 합니다.");
    }
}
