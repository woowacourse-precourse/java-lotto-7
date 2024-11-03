package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
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

    @DisplayName("로또 번호에 범위에 맞지않는 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_범위에_맞지않는_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 90)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("출력시 오름차순 정렬 확인")
    @Test
    void 출력시_오름차순_정렬() {
        List<Integer> numbers = List.of(3, 34, 12, 32, 24, 16);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.toString()).isEqualTo("[3, 12, 16, 24, 32, 34]");
    }

}
