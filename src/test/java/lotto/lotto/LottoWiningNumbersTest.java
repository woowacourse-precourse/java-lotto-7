package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoWiningNumbersTest {

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        // given
        WiningNumbers winingNumbers = new WiningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(1);

        // when & then
        assertThatThrownBy(() -> new LottoWiningNumbers(winingNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
