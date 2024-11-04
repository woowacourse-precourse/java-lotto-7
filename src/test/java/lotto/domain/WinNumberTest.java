package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinNumberTest {
    @Test
    void 보너스_번호가_당첨_번호에_존재하면_예외가_발생한다() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from("3");
        assertThatThrownBy(() -> WinNumber.of(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
