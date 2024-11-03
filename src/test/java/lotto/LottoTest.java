package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 정상_케이스() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        assertThat(lotto.getNumbers().contains(1)).isTrue();
        assertThat(lotto.getNumbers().contains(2)).isTrue();
        assertThat(lotto.getNumbers().contains(3)).isTrue();
        assertThat(lotto.getNumbers().contains(4)).isTrue();
        assertThat(lotto.getNumbers().contains(5)).isTrue();
        assertThat(lotto.getNumbers().contains(6)).isTrue();
    }

    @DisplayName("로또 번호의 개수가 6개 보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 1, 1, 1, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 ~ 45 사이의 범위를 벗어난 로또 번호가 있으면 예외가 발생한다.")
    @Test
    void 범위를_벗어난_로또번호가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
