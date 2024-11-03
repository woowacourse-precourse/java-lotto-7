package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberValidatorTest {
    @Test
    public void 보너스_번호가_1이상_45이하가_아니면_예외가_발생한다() {
        int bonusNumber = 46;
        Lotto winningLotto = new Lotto(List.of(3, 6, 9, 12, 15, 16));
        assertThatThrownBy(()->new BonusNumberValidator(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        int bonusNumber = 15;
        Lotto winningLotto = new Lotto(List.of(3, 6, 9, 12, 15, 16));
        assertThatThrownBy(()->new BonusNumberValidator(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
