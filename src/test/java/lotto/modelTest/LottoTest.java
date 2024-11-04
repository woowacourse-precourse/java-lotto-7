package lotto.modelTest;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 번호 개수가 6개보다 적은 경우 에러가 발생한다.")
    @Test
    public void when_lotto_count_isNot_6() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 번호의 개수가 6개를 초과하면 예외가 발생한다.")
    @Test
    void when_lotto_count_exceed_6() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void when_lotto_numbers_duplicated() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 사이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    public void when_lotto_number_isNotIn_Range() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 50, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 입력이 정상적인 경우 예외가 발생하지 않는다.")
    @Test
    public void should_create_lotto_when_normal_input() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
