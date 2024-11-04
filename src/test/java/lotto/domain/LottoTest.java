package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호가 6개보다 많으면 예외가 발생한다.")
    @Test
    void 로또번호_개수초과_예외발생() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_COUNT_INVALID);
    }

    @DisplayName("로또 번호가 6개보다 적으면 예외가 발생한다.")
    @Test
    void 로또번호_개수미달_예외발생() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_COUNT_INVALID);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또번호_중복_예외발생() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_DUPLICATED);
    }

    @DisplayName("로또 번호가 1보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또번호_범위미만_예외발생() {
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
    }

    @DisplayName("로또 번호가 45보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또번호_범위초과_예외발생() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
    }

    @DisplayName("로또 번호를 정상적으로 생성한다.")
    @Test
    void 로또번호_정상생성() {
        List<Integer> numbers = List.of(45, 1, 23, 17, 8, 33);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).containsExactly(1, 8, 17, 23, 33, 45);
    }

    @DisplayName("로또 번호에 특정 숫자가 포함되어 있는지 확인한다.")
    @Test
    void 로또번호_포함여부_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(3)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @DisplayName("로또 번호 리스트를 수정하려고 하면 예외가 발생한다.")
    @Test
    void 로또번호_리스트_수정_예외발생() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> lotto.getNumbers().add(7));
    }

    @DisplayName("로또 번호에 1과 45가 포함되어도 정상적으로 생성된다.")
    @Test
    void 로또번호_경계값_정상생성() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 45);
    }
}
