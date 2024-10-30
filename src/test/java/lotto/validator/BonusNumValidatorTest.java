package lotto.validator;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class BonusNumValidatorTest {
    private BonusNumValidator bonusNumValidator = new BonusNumValidator(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

    @Test
    void 보너스번호가_로또번호에_있는_번호() {
        Assertions.assertThatThrownBy(() -> bonusNumValidator.validateBonusNum(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스번호가_로또_최대나_최소를_벗어남(int bonusNum) {
        Assertions.assertThatThrownBy(() -> bonusNumValidator.validateBonusNum(bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
