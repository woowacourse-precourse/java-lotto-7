package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    void 로또번호가_빈칸이면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoNumber.winLottoNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
