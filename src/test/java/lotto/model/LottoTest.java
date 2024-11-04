package lotto.model;

import static lotto.utils.Error.LOTTO_NUMBERS_OUT_OF_RANGE;
import static lotto.utils.Error.NOT_SIX_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_SIX_LOTTO_NUMBERS.getDescription());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_toString_재정의_기능_테스트() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(integers.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 6, 5, 4));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 로또_번호가_1에서_45를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBERS_OUT_OF_RANGE.getDescription());
    }
}
