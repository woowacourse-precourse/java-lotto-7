package lotto.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("정확한 로또를 생성한다.")
    public void lotto() {
        // GIVEN
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        Lotto lotto = new Lotto(numbers);

        // THEN
        assertThat(lotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

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


    @Test
    @DisplayName("로또 번호 개수가 6개가 아닌 경우, 예외를 발생시킨다.")
    public void lottoCount() {
        // GIVEN
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // WHEN - THEN
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
