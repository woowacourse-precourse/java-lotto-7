package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다")
    @Test
    void 로또_번호와_보너스번호가_중복되면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(6, lotto.getNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1~45 가 아니면 예외가 발생한다")
    @Test
    void bonusNumberRangeTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(46, lotto.getNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1~45 가 아니면 예외가 발생한다")
    @Test
    void lottoNumbersRangeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 47, 6)))
        .isInstanceOf(IllegalArgumentException.class);
    }
}
