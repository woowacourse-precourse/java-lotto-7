package lotto.model;

import lotto.dto.LottoStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다. 다시 입력해 주세요.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 중복될 수 없습니다. 다시 입력해 주세요.");
    }

    @DisplayName("로또 번호는 1 부터 45 사이의 숫자만 가능하다.")
    @Test
    void invalidRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 0, 46, 2, 3, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 1 부터 45 까지 입력할 수 있습니다. 다시 입력해 주세요.");
    }

    @DisplayName("로또의 상태를 반환할때 숫자들은 오름차순으로 정렬되어 있어야 한다.")
    @Test
    void getLottoStatus() {
        //given
        List<Integer> numbers = List.of(3, 2, 1, 32, 4, 10);
        Lotto lotto = new Lotto(numbers);

        //when
        LottoStatus status = lotto.getStatus();
        List<Integer> statusNumbers = status.getNumbers();

        //then
        assertThat(statusNumbers).isSorted();
    }
}
