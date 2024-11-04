package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.BonusNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void init() {
        bonusNumberValidator = new BonusNumberValidator();
    }

    @Test
    void 보너스_번호가_1에서_45사이가_아닌_경우_예외가_발생한다() {
        String wrongNumber = "1,2,3,4,5,6";

        assertThatThrownBy(() -> bonusNumberValidator.validateBonusNumber("0", wrongNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> bonusNumberValidator.validateBonusNumber("46", wrongNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 보너스_번호가_당첨번호와_같은_경우() {
        assertThatThrownBy(() -> bonusNumberValidator.validateBonusNumber("2", "1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_정수가_아닌_경우() {
        assertThatThrownBy(() -> bonusNumberValidator.validateBonusNumber("a", "1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
