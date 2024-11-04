package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @Test
    void 보너스_번호가_빈칸이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 보너스_번호가_잘못된_입력이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("47"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
