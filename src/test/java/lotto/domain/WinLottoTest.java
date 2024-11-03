package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinLottoTest {

    @Test
    void 당첨_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_45보다_큰_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_1보다_작은_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호랑_보너스_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> winLotto.setBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호에_45보다_큰_숫자가_있으면_예외가_발생한다() {
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> winLotto.setBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호에_1보다_작은_숫자가_있으면_예외가_발생한다() {
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> winLotto.setBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
