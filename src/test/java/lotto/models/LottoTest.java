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
    @DisplayName("로또 번호 범위를 넘어간 경우, 예외를 발생시킨다.")
    public void lottoRange() {
        // GIVEN
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        // WHEN - THEN
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또가 중복된 숫자를 가진 경우, 예외를 발생시킨다.")
    public void lottoDuplicate() {
        // GIVEN
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // WHEN - THEN
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
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
