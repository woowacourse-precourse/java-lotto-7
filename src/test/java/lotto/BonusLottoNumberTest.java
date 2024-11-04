package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.BonusLottoNumber;
import lotto.dto.WinningLottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BonusLottoNumberTest {

    private WinningLottoNumbers winningLottoNumbers;

    @BeforeEach
    void setUp() {
        winningLottoNumbers = WinningLottoNumbers.of("1,2,3,4,5,6");
    }

    @Test
    void 로또_당첨_번호와_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusLottoNumber.from("1", winningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_보너스_번호가_음수면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusLottoNumber.from("-1", winningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_보너스_번호가_문자면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusLottoNumber.from("o.o", winningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_보너스_번호가_자료형_범위를_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusLottoNumber.from("2147483648", winningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
