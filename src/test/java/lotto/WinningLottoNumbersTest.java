package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.WinningLottoNumbers;
import org.junit.jupiter.api.Test;

public class WinningLottoNumbersTest {
    @Test
    void 로또_당첨_번호가_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoNumbers.of("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_번호가_최대범위_이상이면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoNumbers.of("46,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_번호_문자열에_특수문자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoNumbers.of("4%,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_번호_숫자가_없으면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoNumbers.of("o.o"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_번호에_중복번호가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLottoNumbers.of("1,1,1,1,1,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
