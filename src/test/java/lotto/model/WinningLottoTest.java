package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        // given
        Lotto winningLottoNum = new Lotto("1,2,3,4,5,6");
        Number bonusNum = new Number(3); // 중복된 번호

        // when & then
        assertThatThrownBy(() -> new WinningLotto(winningLottoNum, bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
