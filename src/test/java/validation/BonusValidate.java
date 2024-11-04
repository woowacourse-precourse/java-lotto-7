package validation;

import static lotto.validation.BonusNumberValidate.checkContainBonusNumber;
import static lotto.validation.BonusNumberValidate.checkInputBonus;
import static lotto.validation.BonusNumberValidate.checkNumberRange;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BonusValidate {

    @Test
    void 유효하지_않은_보너스_입력은_예외가_발생한다() {
        assertThatThrownBy(() -> checkInputBonus("가나다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위를_벗어난_보너스는_예외가_발생한다() {
        assertThatThrownBy(() -> checkNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이미_당첨번호에_뽑힌_숫자는_보너스로_뽑힐_수_없다() {
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> checkContainBonusNumber(winNumber, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
