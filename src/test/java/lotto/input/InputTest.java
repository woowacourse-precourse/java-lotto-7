package lotto.input;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Cost().validate("1111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber().validate("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber().validate("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_0_이하면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(lotto.getNumbers()).validate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_46_이상이면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(lotto.getNumbers()).validate("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(lotto.getNumbers()).validate("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_숫자만으로_이루어지지_않은_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Cost().validate("1111d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호를_올바르지않은_형식으로_입력할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber().validate("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_숫자만으로_이루어지지_않은_경우_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(lotto.getNumbers())
                .validate("1a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}