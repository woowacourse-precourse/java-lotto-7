package lotto;

import lotto.model.BonusNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class BonusNumberTest {

    @Test
    void 보너스_번호가_1에서_45사이가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> new BonusNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
