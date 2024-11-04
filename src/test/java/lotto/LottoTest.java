package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 번호의 개수가 6개를 넘으면 예외가 발생한다.")
    @Test
    void 로또_번호_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호 중 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 하나의 로또 번호 조합에 중복된 숫자가 포함되어 있습니다.");
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_1에서_45_사이가_아니면_예외가_발생한다() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어 있는지 확인한다.")
    @Test
    void 기능_테스트_로또_번호를_오름차순_정렬한다() {
        List<Integer> numbers = List.of(43, 42, 41, 23, 21, 8);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(List.of(8, 21, 23, 41, 42, 43));
    }
}
