package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.utils.ErrorMessages;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    void 보너스넘버가_범위가_유효하지_않으면_예외_발생(int bonusNumber) {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
    }

    @Test
    void 보너스넘버가_당첨번호와_중복되면_예외_발생() {
        int bonusNumber = 1;
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_LOTTO_NUMBER);
    }

    @Test
    void 보너스넘버가_유효하면_예외가_발생하지_않는다() {
        int bonusNumber = 10;
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatCode(() -> new BonusNumber(bonusNumber, winningNumbers))
                .doesNotThrowAnyException();
    }
}
