package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호가 1에서 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_1에서_45_사이가_아니면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(0, 2, 3, 4, 5, 6)),
                "[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("유효한 로또 번호가 주어지면 예외가 발생하지 않는다.")
    @Test
    void 유효한_로또_번호가_주어지면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되는지 확인한다.")
    @Test
    void 로또_번호가_오름차순으로_정렬되는지_확인한다() {
        Lotto lotto = new Lotto(List.of(45, 1, 23, 10, 5, 33));
        assertThat(lotto.get()).containsExactly(1, 5, 10, 23, 33, 45);
    }
}
