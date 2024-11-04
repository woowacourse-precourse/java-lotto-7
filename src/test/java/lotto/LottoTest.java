package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개이하이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_범위가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 15, 23, 34, 42, 48)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_범위가_더_낮아지면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 2, 2, 2, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 무작위_로또_번호_개수_검증() {
        Lotto lotto = Lotto.generateRandomLotto();
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    void 무작위_로또_번호_범위_검증() {
        Lotto lotto = Lotto.generateRandomLotto();
        lotto.getNumbers().forEach(number ->
                assertThat(number).isBetween(1, 45)
        );
    }

    @Test
    void 무작위_로또_번호_중복_검증() {
        Lotto lotto = Lotto.generateRandomLotto();
        assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
    }
}
