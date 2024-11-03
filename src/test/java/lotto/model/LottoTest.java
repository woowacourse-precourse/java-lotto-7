package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(LottoException.class);
    }

    @Test
    void 로또_번호의_개수가_부족하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1)))
                .isInstanceOf(LottoException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(LottoException.class);
    }

    @DisplayName("로또 번호에 음수가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_음수가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(LottoException.class);
    }

    @DisplayName("로또 번호 중 하나라도 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(999, 2, 3, 4, 5, 6)))
                .isInstanceOf(LottoException.class);
    }

    @DisplayName("Equals()로 두 로또가 같은지 확인한다.")
    @Test
    void 로또_번호_일치_확인() {
        Lotto l1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto l2 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        Assertions.assertThat(l1).isEqualTo(l2);
    }

    @DisplayName("Equals()로 두 로또가 다른지 확인한다.")
    @Test
    void 로또_번호_불일치_확인() {
        Lotto l1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto l2 = new Lotto(List.of(1, 3, 5, 7, 9, 2));
        Assertions.assertThat(l1).isNotEqualTo(l2);
    }

    @DisplayName("로또 번호가 형식대로 출력되는지 확인")
    @Test
    void 로또_번호_출력_확인() {
        Lotto l1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(l1.toString()).contains("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("두 로또 번호의 다른 개수를 출력하는지 확인")
    @Test
    void 로또_번호_차이_확인() {
        Lotto l1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto l2 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Assertions.assertThat(l1.subtract(l2)).isEqualTo(3);
    }
}
