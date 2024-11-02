package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 번호가 null인 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("1장의 로또는 6개의 번호를 가진다.")
    @Test
    void 한장의_로또는_6개의_번호를_가진다() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 번호는 1에서 45사이의 숫자이다.")
    @Test
    void 로또_번호는_1에서_45사이의_숫자이다() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 5, 15, 25, 35, 45)));
    }

    @DisplayName("로또 번호가 1에서 45 사이가 아닌 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_1에서_45_사이가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
