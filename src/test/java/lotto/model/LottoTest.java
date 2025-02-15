package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;
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

    @DisplayName("번호가 1보다 작으면 예외 발생")
    @Test
    void 로또_번호_범위_위반시_예외가_발생한다1() {
        int num = Randoms.pickNumberInRange(-100, 0);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, num)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 45보다 크면 예외 발생")
    @Test
    void 로또_번호_범위_위반시_예외가_발생한다2() {
        int num = Randoms.pickNumberInRange(46, 100);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, num)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
