package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘으면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 범위를 벗어날 경우 예외가 발생한다.")
    void 로또_번호가_범위를_벗어날_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }


    @Test
    @DisplayName("로또 번호가 정상적인 경우 예외가 발생하지 않는다.")
    void 로또_번호가_정상적인_경우_예외가_발생하지_않는다() {
        List<Integer> validLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validLottoNumbers);
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrderElementsOf(validLottoNumbers);
    }
}
