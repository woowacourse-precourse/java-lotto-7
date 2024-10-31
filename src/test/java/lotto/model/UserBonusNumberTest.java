package lotto.model;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserBonusNumberTest {
    @Test
    void 보너스_번호가_입력된_로또_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new UserBonusNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}