package lotto.domain.lottoMachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        Lotto lotto = Lotto.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("1");
        assertThatThrownBy(() -> WinningLotto.of(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
